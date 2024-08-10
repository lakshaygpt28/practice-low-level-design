package Questions.Amazon;

import Questions.Amazon.model.Order;
import Questions.Amazon.model.Product;
import Questions.Amazon.model.ShoppingCart;
import Questions.Amazon.model.User;
import Questions.Amazon.service.*;

import java.math.BigDecimal;

public class AmazonDemo {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        InventoryService inventoryService = new InventoryService();
        ShoppingCartService shoppingCartService = new ShoppingCartService(inventoryService, productService);
        OrderService orderService = new OrderService(inventoryService);
        PaymentService paymentService = new PaymentService();

        // Create users
        User user1 = userService.register("john.doe@example.com", "password123", "John Doe");
        User user2 = userService.register("jane.smith@example.com", "password456", "Jane Smith");

        // Add products to catalog
        Product product1 = productService.addProduct("Laptop", "High-end gaming laptop", 1500.00);
        Product product2 = productService.addProduct("Headphones", "Noise-cancelling headphones", 200.00);

        // Update inventory
        inventoryService.updateStock(product1.getId(), 10);
        inventoryService.updateStock(product2.getId(), 20);

        User user = userService.login("john.doe@example.com", "password123");

        // User adds items to cart
        ShoppingCart cart = shoppingCartService.getCart(user.getId());
        Product product = productService.searchProducts("laptop").get(0);
        shoppingCartService.addItemToCart(cart.getId(), product.getId(), 1);

        // User places an order
        Order order = orderService.placeOrder(user, cart);

        // Process payment
        paymentService.processPayment(order, 2000.00);

        // Handle shipping
//        shippingService.createShipment(order.getOrderId(), user.getAddressList().get(0));

        // Notify user
//        notificationService.sendEmailNotification(user.getUserId(), "Your order has been shipped!");

        // User leaves a review
//        reviewService.addReview(user.getUserId(), product.getProductId(), 5, "Excellent product!");
    }
}
