package reflectiontest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
	public static void main(String[] args) throws
		ClassNotFoundException,
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {
		// normal
		System.out.println("====== Normal ======");
		long beforeTime = System.currentTimeMillis();

		Child child = new Child();
		System.out.println(child.method4(4));

		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("시간차이(ms) : "+secDiffTime);

		// reflection
		System.out.println("====== reflection ======");
		long beforeTime2 = System.currentTimeMillis();

		Child child2 = new Child();
		Class<?> clazz = Class.forName("reflectiontest.Child");
		Method method = clazz.getDeclaredMethod("method4", int.class);
		System.out.println((int)method.invoke(child2, 4));

		long afterTime2 = System.currentTimeMillis();
		long secDiffTime2 = (afterTime2 - beforeTime2);
		System.out.println("시간차이(ms) : "+secDiffTime2);

	}
}
