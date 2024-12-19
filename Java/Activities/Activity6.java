package Java02;

import java.util.*;	
import java.util.ArrayList;
import java.util.List;

class Plane{
	private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    

    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    public void onboard(String passengerName) {
        this.passengers.add(passengerName);
    }

    public Date takeOff() {
    	this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }

    public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }

    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassengers() {
        return passengers;
    }
}


public class Activity6 {

	public static void main(String[] args) throws InterruptedException {

		Plane plane = new Plane(10);

        plane.onboard("virat");
        plane.onboard("dhoni");
        plane.onboard("surya");

        System.out.println("Plane took off at: " + plane.takeOff());
        System.out.println("People on the plane: " + plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());

	}

}
