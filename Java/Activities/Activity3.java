package Java02;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double seconds=1000000000;
		
		double EarthSecond=31557600;
		double MercurySecond=0.2408467;
		double VenusSecond=0.61519726;
		double MarsSecond= 0.61519726;
		double JupiterSecond=11.862615;
		double SaturnSecond=29.447498;
		double UranusSecond=84.016846;
		double NeptuneSecond=164.79132;
		
		
		System.out.println("Age on Earth: " + seconds / EarthSecond);
		System.out.println("Age on Mercury: " + seconds / EarthSecond / MercurySecond);
        System.out.println("Age on Venus: " + seconds / EarthSecond / VenusSecond);
        System.out.println("Age on Mars: " + seconds / EarthSecond / MarsSecond);
        System.out.println("Age on Jupiter: " + seconds / EarthSecond / JupiterSecond);
        System.out.println("Age on Saturn: " + seconds / EarthSecond / SaturnSecond);
        System.out.println("Age on Uranus: " + seconds / EarthSecond / UranusSecond);
        System.out.println("Age on Neptune: " + seconds / EarthSecond / NeptuneSecond);
		
	}

}
