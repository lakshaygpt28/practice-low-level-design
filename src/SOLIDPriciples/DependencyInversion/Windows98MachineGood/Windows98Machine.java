package SOLIDPriciples.DependencyInversion.Windows98MachineGood;

public class Windows98Machine {
    private final KeyBoard keyBoard;
    private final Monitor monitor;

    public Windows98Machine(KeyBoard keyBoard, Monitor monitor) {
        this.keyBoard = keyBoard;
        this.monitor = monitor;
    }
}
