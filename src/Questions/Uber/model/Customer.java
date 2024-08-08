package Questions.Uber.model;

import Questions.Uber.util.IdGenerator;

public class Customer {
    int id;
    String name;
    Location location;

    public Customer(String name, Location location) {
        this.id = IdGenerator.getNextId(Customer.class);
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
