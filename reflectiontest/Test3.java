package reflectiontest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3 {
	public static void main(String[] args) throws
		ClassNotFoundException,
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException, InstantiationException {
		// reflection
		System.out.println("====== reflection ======");
		long beforeTime2 = System.currentTimeMillis();

		Class<?> clazz = Class.forName("reflectiontest.Child");
		Constructor<?> cons = clazz.getDeclaredConstructor();
		Child child2 = (Child) cons.newInstance();
		Method method = clazz.getDeclaredMethod("method4", int.class);
		System.out.println((int)method.invoke(child2, 4));

		long afterTime2 = System.currentTimeMillis();
		long secDiffTime2 = (afterTime2 - beforeTime2);
		System.out.println("시간차이(ms) : " + secDiffTime2);

	}
}
