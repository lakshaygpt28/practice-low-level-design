package Questions.VendingMachine;

import Questions.VendingMachine.model.Coin;
import Questions.VendingMachine.model.Note;
import Questions.VendingMachine.model.Product;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        Product coke = new Product("Coke", 1.5);
        Product pepsi = new Product("Pepsi", 1.5);
        Product water = new Product("Water", 1.0);

        vendingMachine.products.put(coke.getId(), coke);
        vendingMachine.products.put(pepsi.getId(), pepsi);
        vendingMachine.products.put(water.getId(), water);

        vendingMachine.inventory.getInventory().put(coke.getId(), 5);
        vendingMachine.inventory.getInventory().put(pepsi.getId(), 3);
        vendingMachine.inventory.getInventory().put(water.getId(), 2);

        // Select a product
        vendingMachine.selectProduct(coke.getId());

        // Insert coins
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);

        // Insert a note
        vendingMachine.insertNote(Note.FIVE);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

        // Select another product
        vendingMachine.selectProduct(pepsi.getId());

        // Insert insufficient payment
        vendingMachine.insertCoin(Coin.QUARTER);

        // Try to dispense the product
        vendingMachine.dispenseProduct();

        // Insert more coins
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();

    }
}
