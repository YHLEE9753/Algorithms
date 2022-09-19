package InheritanceTest.other;


public class TestObject {
	DiscountPolicy discountPolicy;

	public TestObject(DiscountPolicy discountPolicy) {
		this.discountPolicy = discountPolicy;
	}

	public void change(DiscountPolicy discountPolicy){
		this.discountPolicy = discountPolicy;
	}
}
