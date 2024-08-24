package Questions.VendingMachine.model;

import Questions.Amazon.util.IdGenerator;
import lombok.Getter;

@Getter
public class Product {
    int id;
    double price;
    String name;
    public Product(String productName, double price) {
        this.id = IdGenerator.getNextId(Product.class);
        this.name = productName;
        this.price = price;
    }

}
