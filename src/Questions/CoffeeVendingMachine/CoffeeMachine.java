package Questions.CoffeeVendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {
    private static volatile CoffeeMachine instance;
    private Map<String, Ingredient> inventory;
    private List<Coffee> coffeeMenu;

    CoffeeMachine() {
        inventory = new HashMap<>();
        coffeeMenu = new ArrayList<>();

        initializeInventory(); // this is called first as the instance of ingredients is used in menu.
        initializeCoffeeMenu();

    }

    public static CoffeeMachine getInstance() {
        if (instance == null) {
            synchronized (CoffeeMachine.class) {
                if (instance == null) {
                    instance = new CoffeeMachine();
                }
            }
        }
        return instance;
    }

    private void initializeInventory() {
        inventory.put("Coffee", new Ingredient("Coffee", 10));
        inventory.put("Milk", new Ingredient("Milk", 10));
        inventory.put("Water", new Ingredient("Water", 10));
    }

    private void initializeCoffeeMenu() {
        // Add coffee types to the menu
        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(inventory.get("Coffee"), 1);
        espressoRecipe.put(inventory.get("Water"), 1);
        coffeeMenu.add(new Coffee("Espresso", 2.5, espressoRecipe));

        Map<Ingredient, Integer> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(inventory.get("Coffee"), 1);
        cappuccinoRecipe.put(inventory.get("Water"), 1);
        cappuccinoRecipe.put(inventory.get("Milk"), 1);
        coffeeMenu.add(new Coffee("Cappuccino", 3.5, cappuccinoRecipe));

        Map<Ingredient, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(inventory.get("Coffee"), 1);
        latteRecipe.put(inventory.get("Water"), 1);
        latteRecipe.put(inventory.get("Milk"), 2);
        coffeeMenu.add(new Coffee("Latte", 4.0, latteRecipe));
    }

    public void displayMenu() {
        System.out.println("Displaying Menu!!!");
        for (Coffee coffee: coffeeMenu) {
            System.out.println(coffee.getName() + ": $" + coffee.getPrice());
        }
    }

    public synchronized Coffee selectCoffee(String coffeeName) {
        for (Coffee coffee: coffeeMenu) {
            if (coffeeName.equals(coffee.getName())) {
                return coffee;
            }
        }
        return null;
    }

    public synchronized void dispenseCoffee(Coffee coffee, Payment payment) {
        if (payment.getAmount() >= coffee.getPrice()) {
            if (hasEnoughIngredients(coffee)) {
                System.out.println("Dispensing coffee: " + coffee.getName() + "...");
                updateIngredients(coffee);
                double change = payment.getAmount() - coffee.getPrice();
                if (change > 0) {
                    System.out.println("Please collect your change: $" + change);
                }
            } else {
                System.out.println("Not have enough Ingredients for " + coffee.getName());
            }
        } else {
            System.out.println("Not enough Money!!! for " + coffee.getName());
        }
    }

    private void updateIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry: coffee.getRecipe().entrySet()) {
            Ingredient ingredient= entry.getKey();
            int quantity = entry.getValue();
            ingredient.addQuantity(-quantity);
            if (ingredient.getQuantity() < 3) {
                System.out.println("Low inventory alert: " + ingredient.getName());
            }
        }
    }

    private boolean hasEnoughIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry:  coffee.getRecipe().entrySet()) {
            Ingredient ingredient= entry.getKey();
            int quantity = entry.getValue();
            if (ingredient.getQuantity() < quantity) {
                return false;
            }
        }
        return true;
    }


}

