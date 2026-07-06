package activities;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter numbers");
	
		List<Integer> lt = new ArrayList<>();
			while(sc.hasNextInt()) {
			    lt.add(sc.nextInt());
			}
		
		Random rc = new Random();
		int res = rc.nextInt(lt.size());
		
		System.out.println("list" +lt);
		System.out.println("value " +lt.get(res));

	}

}
