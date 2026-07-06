package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity9 {

	public static void main(String[] args) {
		Set<Object> hs = new HashSet<>();
		
		hs.add(10);
		hs.add("iron");
		hs.add(15.55);
		hs.add(18);
		hs.add('a');
		hs.add(true);
		
		System.out.println("size is "+hs.size());
		hs.remove(10);
		System.out.println(hs.remove(22));
		System.out.println(hs.contains(30));
		System.out.println("Now the size is "+hs.size());
		System.out.println(hs);

	}

}
