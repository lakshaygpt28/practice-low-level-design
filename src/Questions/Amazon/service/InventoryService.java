package Questions.Amazon.service;

import Questions.Amazon.model.InventoryItem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {
    private final Map<Integer, InventoryItem> inventory;

    public InventoryService() {
        inventory = new ConcurrentHashMap<>();
    }

    public void updateStock(int productId, int quantity) {
        InventoryItem inventoryItem = inventory.getOrDefault(productId, new InventoryItem(productId, quantity));
        inventoryItem.setQuantity(quantity);
        inventory.put(inventoryItem.getProductId(), inventoryItem);
    }

    boolean checkStock(int productId, int quantity) {
        InventoryItem inventoryItem = inventory.get(productId);
        if (inventoryItem.getQuantity() < quantity) {
            return false;
        }
        return true;
    }

    boolean reserveStock(int productId, int quantity) {
        if (!checkStock(productId, quantity)) {
            return false;
        }
        InventoryItem inventoryItem = inventory.get(productId);
        inventoryItem.setQuantity(inventoryItem.getQuantity() - quantity);
        return true;
    }

}
