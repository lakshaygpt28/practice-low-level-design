package Questions.VendingMachine.model.state;

import Questions.VendingMachine.VendingMachine;
import Questions.VendingMachine.model.Coin;
import Questions.VendingMachine.model.Note;
import Questions.VendingMachine.model.Product;

public class ProductSelectionState extends VendingMachineState {
    public ProductSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectProduct(int productId) {
        if (vendingMachine.getInventory().isAvailable(productId)) {
            Product product = vendingMachine.getProducts().get(productId);
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getPaymentState());
            System.out.println("Product selected: " + product.getName());
        } else {
            System.out.println("Product is not Available!!!");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select the product first.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select the product first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select the product and make payment.");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return.");
    }
}
