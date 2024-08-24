package Questions.VendingMachine.model.state;

import Questions.VendingMachine.VendingMachine;
import Questions.VendingMachine.model.Coin;
import Questions.VendingMachine.model.Note;
import Questions.VendingMachine.model.Product;

public class DispensingState extends VendingMachineState {
    public DispensingState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectProduct(int productId) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Inserted sufficient money. Please collect the dispensed product.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Inserted sufficient money. Please collect the dispensed product.");
    }

    @Override
    public void dispenseProduct() {
        Product product = vendingMachine.getSelectedProduct();
        double moneyInserted = vendingMachine.getMoneyInserted();
        vendingMachine.setMoneyInserted(moneyInserted - product.getPrice());
        System.out.println("Dispensing product: " + product.getName());
        vendingMachine.getInventory().dispenseProduct(product.getId());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the dispensed product first.");
    }
}
