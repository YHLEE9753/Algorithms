package InheritanceTest;

public class Test2DiscountPolicy implements DiscountPolicy{
	@Override
	public int getCount(int count) {
		return -20;
	}
}
