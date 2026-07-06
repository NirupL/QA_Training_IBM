package activities;


abstract class Book {
	String title;
	
	abstract void setTitle(String s);
	
	String getTitle() {
		return title;
		
	}
}

class MyBook extends Book {

	@Override
	void setTitle(String title) {
		this.title = title;
		System.out.println(title);
		
	}
	
}

public class Activity5 {

	public static void main(String[] args) {
		Book obj = new MyBook();
		obj.setTitle("none");
		System.out.println(obj.getTitle());
		

	}

}
