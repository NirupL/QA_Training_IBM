package activities;

import java.util.ArrayList;
import java.util.List;



public class Activity8 {

	public static void main(String[] args) {
		List<String> myList = new ArrayList<>();
		myList.add("thor");
		myList.add("hulk");
		myList.add("captain america");
		myList.add("ironman");
		myList.add("hawk eye");
		
		for(String names : myList) {
			System.out.println(names);
		}
		
		String name3 = myList.get(2);
		System.out.println("-------------");
		System.out.println(myList.contains(name3));
		System.out.println("Size is "+myList.size());
		myList.remove(3);
		System.out.println("Now the size is "+myList.size());

	}

}
