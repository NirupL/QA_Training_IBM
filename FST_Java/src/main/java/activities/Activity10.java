package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity10 {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "red");
		map.put(2, "green");
		map.put(3, "blue");
		map.put(4, "yellow");
		map.put(5, "white");
		
		System.out.println(map);
		System.out.println("size of map before removal is "+map.size());
		map.remove(3);
		System.out.println(map.containsValue("green"));
		System.out.println("size of map is "+map.size());
		

	}

}
