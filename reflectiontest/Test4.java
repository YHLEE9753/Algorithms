package reflectiontest;

public class Test4 {
	public static void main(String[] args) {
		// normal
		System.out.println("====== Normal ======");
		long beforeTime = System.currentTimeMillis();

		Child child = new Child();
		System.out.println(child.method4(4));

		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("시간차이(ms) : "+secDiffTime);

	}
}
