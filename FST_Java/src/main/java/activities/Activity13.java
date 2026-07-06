package activities;

import java.util.Scanner;

public class Activity13 {

	public static void registerUser(String age) {
		int newAge = Integer.parseInt(age);
		
		try {
			if(newAge < 18) {
				throw new IllegalArgumentException("users must be atleat 18 years");
			}
			else {
				System.out.println("Registration successful! Welcome aboard.");
			}
		}
		catch(NumberFormatException ex) {
			System.out.println("age must be in number");
		}
		catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		catch(Exception ex) {
			System.out.println("Something went wrong");
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age");
		String age = sc.nextLine();
		
		
		new Activity13();
		Activity13.registerUser(age);

	}
}

