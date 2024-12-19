package Java02;

public interface Activity7 {
    public int gears = 0;
    
    public int speed = 0;


public interface BicycleOperations {
    public void applyBrake1(int decrement);

    public void speedUp1(int increment);
}

public class MountainBike implements Activity7, BicycleOperations {
    int currentSpeed;
    int current;
	private int currentGear;
    
    public MountainBike(int gears, int speed) {
        this.currentGear = gears;
        this.currentSpeed = speed;
    }
    
    @Override
    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        System.out.println("Brake applied. Speed reduced by " + decrement + " km/h. Current speed: " + currentSpeed + " km/h");
    }

    // Implement the speedUp method from BicycleOperations
    @Override
    public void speedUp(int increment) {
        currentSpeed += increment;
        System.out.println("Speed increased by " + increment + " km/h. Current speed: " + currentSpeed + " km/h");
    }
    
    public void displayProperties() {
        System.out.println("Mountain Bike - Gears: " + currentGear + ", Max Speed: " + currentSpeed + " km/h");
    }

public class Activity7 {
	
    	    public static void main(String[] args) {
    	        MountainBike bike = new MountainBike(5, 30);

    	        bike.displayProperties();

    	        bike.speedUp1(10);

    	        bike.applyBrake1(5);

    	        bike.speedUp1(15);

    	        bike.applyBrake1(10);
    	    }
    	}


	
}


}
