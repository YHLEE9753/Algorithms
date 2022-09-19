package holymoly;

public class Human extends Animal implements Swimmable, Flyable{
	@Override
	void talk() {
		System.out.println("hi");
	}

	// public void move(){
	// 	System.out.println("!?");
	// }

	public void test(){
		System.out.println("hihihi");
	}

	public Human() {
		this.height = 10;
		this.wight = 20;
	}

	@Override
	public void swim() {
		System.out.println("i can swim!");
	}

	@Override
	public void fly() {
		System.out.println("i can fly!");
	}
}
