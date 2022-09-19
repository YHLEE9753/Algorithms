package holymoly;

public abstract class Animal {
	int height;
	int wight;
	boolean isAlive = true;

	abstract void talk();

	public void move(){
		System.out.println("walking 3");
	}
}
