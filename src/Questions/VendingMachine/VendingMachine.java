package Questions.VendingMachine;

import Questions.VendingMachine.model.Coin;
import Questions.VendingMachine.model.Inventory;
import Questions.VendingMachine.model.Note;
import Questions.VendingMachine.model.Product;
import Questions.VendingMachine.model.state.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class VendingMachine {
    private static VendingMachine instance;
    VendingMachineState productSelectionState;
    VendingMachineState paymentState;
    VendingMachineState dispensingState;
    VendingMachineState returnChangeState;
    VendingMachineState currentState;
    Map<Integer, Product> products;
    Inventory inventory;
    @Setter
    double moneyInserted;
    @Setter
    Product selectedProduct;

    private VendingMachine() {
        inventory = new Inventory();
        products = new ConcurrentHashMap<>();
        productSelectionState = new ProductSelectionState(this);
        paymentState = new PaymentState(this);
        dispensingState = new DispensingState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = productSelectionState;
        moneyInserted = 0.0;
        selectedProduct = null;
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void selectProduct(int productId) {
        currentState.selectProduct(productId);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public void setState(VendingMachineState vendingMachineState) {
        currentState = vendingMachineState;
    }

    public void resetMoneyInserted() {
        moneyInserted = 0.0;
    }

    public void resetSelectedProduct() {
        selectedProduct = null;
    }

    public void addCoin(Coin coin) {
        moneyInserted += coin.getValue();
    }

    public void addNote(Note note) {
        moneyInserted += note.getValue();
    }
}
