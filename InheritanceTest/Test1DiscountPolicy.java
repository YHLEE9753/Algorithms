package InheritanceTest;

public class Test1DiscountPolicy implements DiscountPolicy{
	@Override
	public int getCount(int count) {
		return 10;
	}
}
