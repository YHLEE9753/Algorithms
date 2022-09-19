package InheritanceTest.other;

public class Test2DiscountPolicy extends DiscountPolicy{
	@Override
	int getCount(int count) {
		return -10;
	}
}
