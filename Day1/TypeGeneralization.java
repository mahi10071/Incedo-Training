package hello;

abstract class animal{
	String name;
	public animal(String name) {
		this.name=name;
	}
	
	public abstract void speak();
	
	public void eat()
	{
		System.out.println(name + "is eating");
	}
	
}

class dog extends animal{
	public dog(String name) {
		super(name);
	}
	
	@Override
	public void speak() {
		System.out.println(name + "barks.");
	}
}
class cat extends animal{
	public cat(String name) {
		super(name);
	}
	
	@Override 
	public void speak() {
		System.out.println(name + "meows");
	}
	
	
}
class bird extends animal{
	public bird(String name) {
		super(name);
	}
	@Override
    public void speak() {
        System.out.println(name + " chirps.");
    }
}



public class TypeGeneralization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		animal dogg = new dog("buddy");
		animal catt = new cat("whiskers");
		animal birdd = new bird("tweety");
		
		dogg.speak();
		dogg.eat();
		
		catt.speak();
		catt.eat();
		
		birdd.speak();
		birdd.eat();
		
		
		
	}

}
