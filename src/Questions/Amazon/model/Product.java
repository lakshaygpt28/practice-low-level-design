package Questions.Amazon.model;

import Questions.Amazon.util.IdGenerator;

import java.math.BigDecimal;

public class Product {
    private final int id;
    private final String name;
    private final String description;
    private BigDecimal price;

    public Product(String name, String description, BigDecimal price) {
        this.id = IdGenerator.getNextId(Product.class);
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
