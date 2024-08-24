package Questions.VendingMachine.model;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Inventory {
    private final Map<Integer, Integer> inventory;

    public Inventory() {
        inventory = new ConcurrentHashMap<>();
    }

    public boolean isAvailable(int productId) {
        return inventory.containsKey(productId) && inventory.get(productId) > 0;
    }

    public void dispenseProduct(int productId) {
        inventory.put(productId, inventory.get(productId) - 1);
    }
}
