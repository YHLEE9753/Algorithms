package InheritanceTest;

public class Main {
	public static void main(String[] args) {
		TestObject testObject = new TestObject(new Test1DiscountPolicy());

		testObject.changePolicy(new Test2DiscountPolicy());
	}
}
