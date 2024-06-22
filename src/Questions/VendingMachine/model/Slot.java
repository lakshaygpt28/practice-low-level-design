package Questions.VendingMachine.model;

public class Slot {
    int id;
    Product product;
    int quantity;

    public Slot(int id) {
        this.id = id;
        this.product = null;
        this.quantity = 0;
    }
    public Slot(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public boolean addProduct(Product product, int quantity) {
        if (this.product == null) {
            this.product = product;
            this.quantity = quantity;
        } else if (this.product.id != product.id) {
            return false;
        }
        this.quantity += quantity;
        return true;
    }
}
