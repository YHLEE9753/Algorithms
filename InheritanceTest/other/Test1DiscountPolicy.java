package InheritanceTest.other;

public class Test1DiscountPolicy extends DiscountPolicy {
	@Override
	int getCount(int count) {
		return 10;
	}
}
