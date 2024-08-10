package Questions.Amazon.service;

import Questions.Amazon.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductService {
    private Map<Integer, Product> products;

    public ProductService() {
        products = new ConcurrentHashMap<>();
    }

    public Product addProduct(String name, String description, double price) {
        Product product = new Product(name, description, BigDecimal.valueOf(price));
        products.put(product.getId(), product);
        return product;
    }

    public List<Product> searchProducts(String keyword) {
        List<Product> searchedProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }

    public Product getProductById(int productId) {
        return products.get(productId);
    }
}
