package Questions.Amazon.model;

import Questions.Amazon.util.IdGenerator;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private final int id;
    int userId;
    List<OrderItem> orderItems;
    BigDecimal cost;
    OrderStatus status;

    public Order(int userId, List<OrderItem> orderItems, BigDecimal cost) {
        this.id = IdGenerator.getNextId(Order.class);
        this.userId = userId;
        this.orderItems = orderItems;
        this.cost = cost;
        this.status = OrderStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
