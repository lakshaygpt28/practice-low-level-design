package Questions.Amazon.model;

import Questions.Amazon.util.IdGenerator;

public class CartItem {
    int id;
    int productId;
    int quantity;

    public CartItem(int productId, int quantity) {
        this.id = IdGenerator.getNextId(CartItem.class);
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }
}
