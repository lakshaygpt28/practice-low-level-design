package Questions.Splitwise;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private final int id;
    private final String name;
    private Map<Integer, BigDecimal> balances;


    public User(int id, String name) {
        this.id = id;
        this.name = name;
        balances = new ConcurrentHashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, BigDecimal> getBalances() {
        return balances;
    }
}
