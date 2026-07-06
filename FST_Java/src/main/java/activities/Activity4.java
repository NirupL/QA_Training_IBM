package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		int[] arr = {4,3,2,10,12,1,5,6};
		
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>0; j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					
				}
				
			}
			
		}
		System.out.println(Arrays.toString(arr));

	}

}
