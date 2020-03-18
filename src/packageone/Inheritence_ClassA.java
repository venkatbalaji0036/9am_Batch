package packageone;

public class Inheritence_ClassA extends Inheritence_ClassB{
	public static void main(String[] args) {
		//Inheritence_ClassB obj = new Inheritence_ClassB();
		//obj.Method_B();
		//super.Method_B();
		
		Inheritence_ClassA obj1 = new Inheritence_ClassA();
		obj1.Print_Method_One(10, "Text");
	}
	
	public static void Method_B() {
		System.out.println("This is in Method_B in ClassA");
	}


	
	public void Print_Method_One(int i) {
		
	}
	
	public void Print_Method_One(String value) {
		
	}
	
	public void Print_Method_One(int i, String j) {
		
	}
	
	public void Print_Method_One(String i, int j) {
		
	}
}
