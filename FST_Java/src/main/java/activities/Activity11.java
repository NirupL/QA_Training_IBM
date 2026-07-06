package activities;

@FunctionalInterface
interface Addable{
	public int add(int num1, int num2);
}

public class Activity11 {

	public static void main(String[] args) {
		
		Addable ad1 = (int num1,int num2) -> num1 + num2;
		
		Addable ad2 = (int num1, int num2) -> {
			return num1 + num2;
		};
		
		System.out.println(ad1.add(18,93));
		System.out.println(ad2.add(71,69));

	}

}
