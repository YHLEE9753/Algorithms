package InheritanceTest;

public class TestObject {
	DiscountPolicy discountPolicy;

	public TestObject(DiscountPolicy discountPolicy) {
		this.discountPolicy = discountPolicy;
	}

	public void changePolicy(DiscountPolicy discountPolicy){
		this.discountPolicy = discountPolicy;
	}
}
