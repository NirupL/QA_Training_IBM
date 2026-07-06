package activities;

interface BicycleParts{
	 int tyres = 0;
	 int maxSpeed = 50;
}

interface BicycleOperations{
	void applyBrake(int decrement);
	void speedUp(int increment);
}

class Bicycle implements BicycleParts,BicycleOperations{

	int gears;
	int currentSpeed;
	
	
	public Bicycle(int gears, int currentSpeed) {
		super();
		this.gears = gears;
		this.currentSpeed = currentSpeed;
	}

	@Override
	public void applyBrake(int decrement) {
		this.currentSpeed -= decrement;
		System.out.println("Brake is applied speed reduced to  "+this.currentSpeed +"kmph");
		
		
	}

	@Override
	public void speedUp(int increment) {
		
		this.currentSpeed += increment;
		System.out.println("The Bicycle is speeding up to "+this.currentSpeed + "kmph");
		
		
	}
	
	public void bicycleDesc() {
		System.out.println("The Bicycle has "+this.gears+ " gears");
		System.out.println("The current Speed of the bicycle is "+this.currentSpeed +"kmph");
		
	}
	
	
}

class MountainBike extends Bicycle{

	int seatHeight;
	
	public MountainBike(int gears, int currentSpeed, int seatHeight ) {
		super(gears, currentSpeed);
		this.seatHeight = seatHeight;
	}
	
	public void setHeight(int newHeight) {
		seatHeight += newHeight;
	}
	
	@Override
	public void bicycleDesc() {
		System.out.println("The Bicycle has "+this.gears+ " gears");
		System.out.println("The current Speed of the bicycle is "+this.currentSpeed + "kmph");
		System.out.println("The new seat height of the bicycle is "+this.seatHeight);
		
	}
	
}
public class Activity7 {

	public static void main(String[] args) {
		MountainBike bk = new MountainBike(5, 20 ,3);
		bk.setHeight(5);
		bk.bicycleDesc();
		bk.applyBrake(5);
		bk.speedUp(15);
		
		
		

	}

}
