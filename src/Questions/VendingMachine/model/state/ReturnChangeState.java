package Questions.VendingMachine.model.state;

import Questions.VendingMachine.VendingMachine;
import Questions.VendingMachine.model.Coin;
import Questions.VendingMachine.model.Note;

public class ReturnChangeState extends VendingMachineState {
    public ReturnChangeState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectProduct(int productId) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product already dispensed. Please collect the change.");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getMoneyInserted();
        if (change > 0.0) {
            System.out.println("Returned change $:" + change);
            vendingMachine.resetMoneyInserted();
        } else {
            System.out.println("No change to return.");
        }
        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getProductSelectionState());
    }
}
