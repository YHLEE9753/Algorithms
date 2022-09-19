package holymoly;

public class Giant {
	int count;
	Animal animal;
	Flyable flyable;
	Swimmable swimmable;

	public Giant(int count, Animal animal, Flyable flyable, Swimmable swimmable) {
		this.count = count;
		this.animal = animal;
		this.flyable = flyable;
		this.swimmable = swimmable;
	}
}
