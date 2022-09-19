package holymoly;

public class Main {
	public static void main(String[] args) {
		Giant giant = new Giant(10, new Human(), new Human(), new Human());

		Animal animal = new Human();
		animal.talk();
		animal.move();
	}
}
