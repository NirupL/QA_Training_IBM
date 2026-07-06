package activities;

public class Car {
	String color;
	String transmission;
	int make  ;
	int tyres ;
	int doors ;
	
	
	public Car(String color, String transmission, int make, int tyres, int doors) {
		super();
		this.color = color;
		this.transmission = transmission;
		this.make = make;
		this.tyres = tyres;
		this.doors = doors;
	}

	public void displayCharacteristics() {
		System.out.println("Color is "+color);
		System.out.println("Tramission is "+transmission);
		System.out.println("Make is "+make);
		System.out.println("Tyres are "+tyres);
		System.out.println("Doors is "+doors);
	}
	public void accelerate() {
		System.out.println("Car is moving forward");
	}
	public void brake() {
		System.out.println("Car has stopped");
	}
}
