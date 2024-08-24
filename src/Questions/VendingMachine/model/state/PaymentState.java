package Questions.VendingMachine.model.state;

import Questions.VendingMachine.VendingMachine;
import Questions.VendingMachine.model.Coin;
import Questions.VendingMachine.model.Note;

public class PaymentState extends VendingMachineState {
    public PaymentState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectProduct(int productId) {
        System.out.println("Product already selected. Please insert money.");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: " + coin);
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted: " + note);
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Insufficient amount. Please insert more money.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment first");
    }

    private void checkPaymentStatus() {
        if (vendingMachine.getMoneyInserted() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setState(vendingMachine.getDispensingState());
        }
    }
}
