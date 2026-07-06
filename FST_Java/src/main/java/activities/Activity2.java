package activities;

public class Activity2 {

	public static void main(String[] args) {
		int[] arr = {10,20,10,30,40,10};
		boolean res = equalTo10(arr);
		System.out.println(res);
		

	}
	public static boolean equalTo10(int[] arr) {
		int sum = 0;
		
		for(int newArr : arr) {
			if(newArr == 10) {
				sum += newArr;
			}
		}
		if(sum == 30) return true;
		else return false;
	}

}
