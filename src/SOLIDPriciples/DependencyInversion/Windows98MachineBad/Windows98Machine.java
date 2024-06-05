package SOLIDPriciples.DependencyInversion.Windows98MachineBad;

public class Windows98Machine {
    private final StandardKeyBoard standardKeyBoard;
    private final Monitor monitor;

    // By declaring the StandardKeyboard and Monitor with the new keyword,
    // we’ve tightly coupled these three classes together.

    public Windows98Machine() {
        standardKeyBoard = new StandardKeyBoard();
        monitor = new Monitor();
    }
}
