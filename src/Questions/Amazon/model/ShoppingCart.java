package Questions.Amazon.model;

import Questions.Amazon.util.IdGenerator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCart {
    int id;
    int userId;
    Map<Integer, CartItem> items;
    BigDecimal cost;

    public ShoppingCart(int userId) {
        this.id = IdGenerator.getNextId(ShoppingCart.class);
        this.userId = userId;
        this.items = new ConcurrentHashMap<>();
        this.cost = BigDecimal.ZERO;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
