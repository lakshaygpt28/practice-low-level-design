package SOLIDPriciples.InterfaceSegregation.GoodExample;

public class Manager {
    IWorkable worker;
    public void setWorker(IWorkable w) {
        worker = w;
    }

    public void manage() {
        worker.work();
    }
}
