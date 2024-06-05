package SOLIDPriciples.InterfaceSegregation.BadExample;

/*
* the new Robot class is forced to implement the eat method. We can write a dummy class which does
* nothing(let's say a launch break of 1 second daily), and can have undesired effects in the application
* (For example the reports seen by managers will report more lunches taken than the number of people).
*
* */
public class Robot implements IWorker {
    public void work() {

    }
    public void eat() {
        // Robots can't eat but this class needs to implement these methods anyhow as IWorker has these methods
    }
}
