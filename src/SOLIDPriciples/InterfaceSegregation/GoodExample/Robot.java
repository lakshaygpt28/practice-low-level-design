package SOLIDPriciples.InterfaceSegregation.GoodExample;

/*
* By splitting the IWorker interface in 2 different interfaces the new Robot class is no longer forced to implement
* the eat method. Also, if we need another functionality for the robot like recharging we create another interface
* IRechargeble with a method recharge.
*
* */
public class Robot implements IWorkable, IRechargeble {
    public void work() {
        // ...... working
    }
    public void recharge() {
        // ...... recharging
    }

}
