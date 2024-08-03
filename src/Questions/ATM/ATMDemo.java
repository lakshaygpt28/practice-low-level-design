package Questions.ATM;

public class ATMDemo {
    public static void main(String[] args) {
        BankingService bankingService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser(10000);
        ATM atm = new ATM(bankingService, cashDispenser);

        bankingService.createAccount("12312412545", 10000);
        bankingService.createAccount("78601208219", 5000);

        Card debitCard = new Card("12312412545", 1234);

        // authenticate
        atm.authenticateCard(debitCard);

        atm.withdrawCash("12312412545", 500);
        atm.depositCash("78601208219", 200);

        int balance = atm.checkBalance("12312412545");
        System.out.println("Updated account balance: " + balance);

    }
}
