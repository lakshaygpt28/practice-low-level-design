package Questions.Amazon.service;

import Questions.Amazon.model.CartItem;
import Questions.Amazon.model.Product;
import Questions.Amazon.model.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCartService {
    private Map<Integer, ShoppingCart> shoppingCart;
    private InventoryService inventoryService;
    private ProductService productService;

    public ShoppingCartService(InventoryService inventoryService, ProductService productService) {
        this.shoppingCart = new ConcurrentHashMap<>();
        this.inventoryService = inventoryService;
        this.productService = productService;
    }

    public ShoppingCart getCart(int userId) {
        shoppingCart.putIfAbsent(userId, new ShoppingCart(userId));
        return shoppingCart.get(userId);
    }

    public void addItemToCart(int cartId, int productId, int quantity) {
        ShoppingCart cart = shoppingCart.get(cartId);
        if (cart == null) {
            System.out.println("Cart not found.");
            return;
        }
        CartItem existingItem = cart.getItems().get(productId);
        Product product = productService.getProductById(productId);
        if (existingItem != null) {
            int totalQuantity = existingItem.getQuantity() + quantity;
            if (inventoryService.checkStock(productId, totalQuantity)) {
                existingItem.setQuantity(totalQuantity);
            } else {
                System.out.println("Insufficient stock for product.");
                return;
            }
        }
        if (inventoryService.checkStock(productId, quantity)) {
            CartItem cartItem = new CartItem(productId, quantity);
            cart.getItems().put(cartItem.getId(), cartItem);
        } else {
            System.out.println("Insufficient stock for product.");
            return;
        }
        cart.setCost(cart.getCost().add(product.getPrice().multiply(BigDecimal.valueOf(quantity))));
    }
}
