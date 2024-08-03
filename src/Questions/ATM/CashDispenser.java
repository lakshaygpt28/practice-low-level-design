package Questions.ATM;

public class CashDispenser {
    private int availableCash;

    public CashDispenser(int availableCash) {
        this.availableCash = availableCash;
    }

    public void addCash(int addedAmount) {
        availableCash += addedAmount;
    }

    public void dispenseCash(int amount) {
        if (availableCash < amount) {
            System.out.println("Insufficient cash available in the ATM.");
            return;
        }
        availableCash -= amount;
        System.out.println("Cash dispensed: $" + amount);
    }
}
