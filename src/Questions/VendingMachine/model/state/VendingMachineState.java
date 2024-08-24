package Questions.VendingMachine.model.state;

import Questions.VendingMachine.VendingMachine;
import Questions.VendingMachine.model.Coin;
import Questions.VendingMachine.model.Note;

public abstract class VendingMachineState {
    protected final VendingMachine vendingMachine;
    public VendingMachineState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    public void selectProduct(int productId) {}
    public void insertCoin(Coin coin) {}
    public void insertNote(Note note) {}
    public void dispenseProduct() {}
    public void returnChange() {}
}
