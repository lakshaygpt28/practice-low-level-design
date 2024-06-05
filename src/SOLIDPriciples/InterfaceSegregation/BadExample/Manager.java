package SOLIDPriciples.InterfaceSegregation.BadExample;

public class Manager {
    IWorker worker;
    Manager(IWorker worker) {
        this.worker = worker;
    }

    public void manage() {
        this.worker.work();
    }
}
