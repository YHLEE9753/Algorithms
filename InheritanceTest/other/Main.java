package InheritanceTest.other;


public class Main {
	public static void main(String[] args) {
		TestObject testObject = new TestObject(new Test1DiscountPolicy());

		testObject.change(new Test2DiscountPolicy());
	}
}

