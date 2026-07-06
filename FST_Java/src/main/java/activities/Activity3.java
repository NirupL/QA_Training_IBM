package activities;

public class Activity3 {

	public static void main(String[] args) {
		Activity3 obj = new Activity3();
		
		System.out.println(obj.adjustDevice("THERMOSTAT", 41));
		System.out.println(obj.adjustDevice("THERMOSTAT", 25));
		System.out.println(obj.adjustDevice("LIGHT", 50));

	}
	public static String adjustDevice(String device, int value) {
		
		return switch(device) {
		case null -> "Error cannot be null";
		case  String d when d.equals("THERMOSTAT") && value > 40 -> "Temp is high ";
		case "THERMOSTAT" -> "Temperature is set to value "+value;
		case "LIGHT" -> "Adjusting brightness to "+value+ " %";
		default -> "Unknown device given";
		};
		
		
	}

}
