package Questions.ElevatorSystem;

import Questions.ElevatorSystem.elevatorControlStrategy.LookAlgorithm;
import Questions.ElevatorSystem.elevatorSelectionStrategy.OddEvenStrategy;
import Questions.ElevatorSystem.model.Direction;
import Questions.ElevatorSystem.model.Floor;

public class ElevatorDemo {
    public static void main(String[] args) {
        //ElevatorSystem is singleton class
        ElevatorSystem elevatorSystem= ElevatorSystem.getInstance();
        elevatorSystem.setElevatorSelectionStrategy(new OddEvenStrategy());
        elevatorSystem.setElevatorControlStrategy(new LookAlgorithm());

        //add Floors
        int totalFloors= 50;
        for(int i=0; i<=totalFloors; i++)
        {
            elevatorSystem.addFloor(new Floor(i));
        }
        System.out.println("No. of floors added " + totalFloors);

        //add elevators
        int totalElevators = 4;
        for(int i=1; i<=totalElevators; i++)
        {
            elevatorSystem.addElevator(new ElevatorController());
        }
        System.out.println("No. of elevators added " + totalElevators);

        //Request 1
        System.out.println("Person at floor 1 presses UP Button");
        Floor floor1 = elevatorSystem.getFloors().get(1);
        floor1.pressButton(Direction.UP);

        //Request 2
        System.out.println("Person at floor 5 presses UP Button");
        Floor floor5 = elevatorSystem.getFloors().get(5);
        floor5.pressButton(Direction.UP);

        //Request 3
        System.out.println("Person presses 10 in elevator 2");
        ElevatorController elevatorController2 = elevatorSystem.getElevatorControllers().get(2);
        elevatorController2.getElevatorCar().pressButton(10);

        //Request 4
        System.out.println("Person presses 6 in elevator 2");
        elevatorController2.getElevatorCar().pressButton(6);

        //Request 5
        System.out.println("Person at floor 7 presses DOWN Button");
        Floor floor7 = elevatorSystem.getFloors().get(7);
        floor5.pressButton(Direction.DOWN);

        //Request 6
        System.out.println("Person presses 1 in elevator 3");
        ElevatorController elevatorController3 = elevatorSystem.getElevatorControllers().get(3);
        elevatorController3.getElevatorCar().pressButton(1);


    }
}
