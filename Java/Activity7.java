package Session1;



public class Activity7 implements BicycleOperations {
    // Instance variables for current speed and gear of the bike
    int currentSpeed;
    private int currentGear;

    // Constructor to initialize gear and speed
    public Activity7(int gears, int speed) {
        this.currentGear = gears;
        this.currentSpeed = speed;
    }

    // Implementing the applyBrake method from BicycleOperations interface
    @Override
    public void applyBrake(int decrement) {
        currentSpeed -= decrement; // Reducing the current speed by decrement
        System.out.println("Brake applied. Speed reduced by " + decrement + " km/h. Current speed: " + currentSpeed + " km/h");
    }

    // Implementing the speedUp method from BicycleOperations interface
    @Override
    public void speedUp(int increment) {
        currentSpeed += increment; // Increasing the current speed by increment
        System.out.println("Speed increased by " + increment + " km/h. Current speed: " + currentSpeed + " km/h");
    }

    // Method to display the properties of the bike
    public void displayProperties() {
        System.out.println("Mountain Bike - Gears: " + currentGear + ", Max Speed: " + currentSpeed + " km/h");
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create a Activity7 object with 5 gears and initial speed of 30 km/h
        Activity7 bike = new Activity7(5, 30);
        
        // Display the properties of the bike
        bike.displayProperties();

        // Perform some operations on the bike
        bike.speedUp(10); // Increase speed by 10
        bike.applyBrake(5); // Apply brake, reducing speed by 5
        bike.speedUp(15); // Increase speed by 15
        bike.applyBrake(10); // Apply brake, reducing speed by 10
    }
}
