package Questions.Amazon.service;

import Questions.Amazon.model.Order;
import Questions.Amazon.model.OrderItem;
import Questions.Amazon.model.ShoppingCart;
import Questions.Amazon.model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrderService {
    private Map<Integer, Order> orders;
    private InventoryService inventoryService;

    public OrderService(InventoryService inventoryService) {
        this.orders = new ConcurrentHashMap<>();
        this.inventoryService = inventoryService;
    }

    public Order placeOrder(User user, ShoppingCart cart) {
        List<OrderItem> orderItems = cart.getItems().values().stream().map( cartItem ->
                new OrderItem(cartItem.getProductId(), cartItem.getQuantity())
        ).toList();

        for (OrderItem orderItem : orderItems) {
            if (!inventoryService.checkStock(orderItem.getProductId(), orderItem.getQuantity())) {
                System.out.println("Insufficient stock for product: " + orderItem.getProductId());
                return null;
            }
        }

        for (OrderItem orderItem : orderItems) {
            inventoryService.reserveStock(orderItem.getProductId(), orderItem.getQuantity());
        }

        Order order = new Order(user.getId(), orderItems, cart.getCost());
        orders.put(order.getId(), order);
        System.out.println("Order : " + order.getId() + " placed successfully, please proceed with payment of $" + order.getCost());
        return order;
    }
}
