package Questions.CoffeeVendingMachine;

public class CoffeeVendingMachine {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

        // Display coffee menu
        coffeeMachine.displayMenu();

        // Simulate user requests
        Coffee espresso = coffeeMachine.selectCoffee("Espresso");
        coffeeMachine.dispenseCoffee(espresso, new Payment(3.0));

        Coffee cappuccino = coffeeMachine.selectCoffee("Cappuccino");
        coffeeMachine.dispenseCoffee(cappuccino, new Payment(3.5));

        Coffee latte = coffeeMachine.selectCoffee("Latte");
        coffeeMachine.dispenseCoffee(latte, new Payment(4.0));

        coffeeMachine.dispenseCoffee(latte, new Payment(3.0));
        coffeeMachine.dispenseCoffee(latte, new Payment(5.0));
        coffeeMachine.dispenseCoffee(latte, new Payment(5.0));

        coffeeMachine.dispenseCoffee(latte, new Payment(5.0));
        coffeeMachine.dispenseCoffee(latte, new Payment(5.0));
        coffeeMachine.dispenseCoffee(latte, new Payment(5.0));


    }
}
