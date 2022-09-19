package reflectiontest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws
		ClassNotFoundException,
		NoSuchMethodException,
		NoSuchFieldException,
		InvocationTargetException,
		IllegalAccessException, InstantiationException {
		// 1. class 찾기
		// IDE 에서 클래스를 알고 있는 전제시 사용가능
		System.out.println("========== 1. 클래스 찾기 ===========");
		Class<Child> clazz = Child.class;
		System.out.println("Class name: " + clazz.getName());

		// 클로새를 참조할 수 없고, 이름만 알고 있을대 클래스 정보를 가져오는 방법
		Class<?> clazz2 = Class.forName("reflectiontest.Child");
		System.out.println("Class name: " + clazz2.getName());

		// 2. constructor 찾기
		// 클래스로부터 생성자를 가져오는 코드. getDeclaredConstructor()는 인자 없는 생성자를 가져온다
		System.out.println("========== 2. constructor 찾기 ===========");
		Class<?> clazz3 = Class.forName("reflectiontest.Child");
		Constructor<?> constructor = clazz3.getDeclaredConstructor();
		System.out.println("Constructor: " + constructor.getName());

		// getDeclaredConstructor(Param)에 인자를 넣으면 그 타입과 일치하는 생성자를 찾습니다.
		Constructor<?> constructor2 = clazz3.getDeclaredConstructor(String.class);
		System.out.println("Constructor(String): " + constructor2.getName());

		// getDeclaredConstructors()는 클래스의 private, public 등의 모든 생성자를 리턴해 줍니다.
		// + getConstructors()는 public 생성자만 리턴해준다.
		Class<?> clazz4 = Class.forName("reflectiontest.Child");
		Constructor<?>[] constructors = clazz4.getDeclaredConstructors();
		for (Constructor<?> cons : constructors) {
			System.out.println("Get constructors in Child: " + cons);
		}

		// 3. Method 찾기
		// getDeclaredMethod()의 인자로 메소드의 파라미터 정보를 넘겨주면 일치하는 것을 찾아준다
		System.out.println("========== 3. Method 찾기 ===========");
		Class<?> clazz5 = Class.forName("reflectiontest.Child");
		Method method1 = clazz5.getDeclaredMethod("method4", int.class);
		System.out.println("Find out method4 method in Child: " + method1);
		System.out.println();

		// 인자가 없는 메소드라면 다음과 같이 null을 전달하면 된다
		// getDeclaredMethod()으로 메소드를 찾을 때 존재하지 않는다면 NoSuchMethodException 에러 발생
		// Method method2 = clazz.getDeclaredMethod("method4", null); - 에러 발생

		// 인자가 두개 이상이라면 아래처럼 클래스 배열을 만들어서 인자를 넣어주면 된다.
		Class<?> clazz6 = Class.forName("reflectiontest.Child");
		Class partypes[] = new Class[1];
		partypes[0] = int.class;
		Method method2 = clazz.getDeclaredMethod("method4", partypes);

		// 모든 메소드를 찾으려면, 다음과 같이 getDeclaredMethods를 사용하면 된다.
		// 공통적으로 함수 이름에 Declared가 들어가면 Super 클래스의 정보는 가져오지 않는다.
		Class<?> clazz7 = Class.forName("reflectiontest.Child");
		Method methods[] = clazz7.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("Get methods in Child: " + method);
		}

		// 4. Field(변수) 변경
		// getDeclaredField()에 전달된 이름과 일치하는 Field를 찾아준다
		System.out.println("========== 4. Field(변수) 변경 ===========");
		Class<?> clazz8 = Class.forName("reflectiontest.Child");
		Field field = clazz8.getDeclaredField("cstr1");
		System.out.println("Find out cstr1 field in Child: " + field);

		// 객체에 선언된 모든 Field를 찾으려면 getDeclaredFields()를 사용하면 된다.
		// 위에서 말한 것처럼 상속받은 객체의 정보는 찾아주지 않는다.
		Class<?> clazz9 = Class.forName("reflectiontest.Child");
		Field fields[] = clazz9.getDeclaredFields();
		for (Field fi : fields) {
			System.out.println("Get fields in Child: " + fi);
		}

		// 상속받은 클래스를 포함한 public Field를 찾으려면 getFields()를 사용하면 된다.
		Class<?> clazz10 = Class.forName("reflectiontest.Child");
		Field fields2[] = clazz10.getFields();
		for (Field fi : fields2) {
			System.out.println("Get public fields in both Parent and Child: " + fi);
		}

		// 5. Method 호출
		// 클래스로부터 메소드 정보를 가져와 객체의 메소드를 호출할 수 있다.
		// 메서드 객체를 생성했다면, Method.invoke() 로 호출할 수 있다.
		// 첫번째 인자는 호출하려는 객체이고, 두번째 인자는 전달할 파라미터 값이다.
		System.out.println("========== 5. Method 호출 ===========");
		Child child = new Child();
		Class<?> clazz11 = Class.forName("reflectiontest.Child");
		Method method3 = clazz11.getDeclaredMethod("method4", int.class);
		int returnValue = (int)method3.invoke(child, 10);
		System.out.println("return Value: " + returnValue);

		// Parent 의 method1() 을 호출해보자. 이 메소드는 인자가 없다
		// 따라서 getDeclaredMethod() 에 인자를 입력하지 않아도 () 된다
		// getDeclaredMethod 는 상속받은 클래스의 정보를 가져오지 않기 때문에 Parent 에 대한 클래스 정보를 가져와야 한다.
		Child child2 = new Child();
		Class clazz12 = Class.forName("reflectiontest.Parent");
		Method method4 = clazz12.getDeclaredMethod("method1");
		method4.setAccessible(true); // 해당설정을 통해 private 메소드에 접근가능하다
		method4.invoke(child2);

		// 6. Field 변경
		// 클래스로부터 변수 정보를 가져와 객체의 변수를 변경할 수 있다.
		// 다음 코드는 cstr1 변수를 가져와서 값을 출력하고 변경한 뒤 다시 출력하는 예제이다.
		System.out.println("========== 6. Field 변경 ===========");
		Child child3 = new Child();
		Class clazz13 = Class.forName("reflectiontest.Child");
		Field fld2 = clazz13.getDeclaredField("cstr2");
		fld2.setAccessible(true); // private 변수 수정을 위해 setAccessible 사용
		fld2.set(child3, "cstr2");
		System.out.println("child.cstr2: " + fld2.get(child));

		// 7. static 메소드 호출 및 필드 변경
		// 메소드 정보를 가져오는 방법은 위와 동일하다.
		// 다만 호출할 때 invoke()로 객체를 전달하는 인자에 null을 넣어주시면 된다.
		// 그럼 static 메소드가 호출됩니다.
		System.out.println("========== 7. static 메소드 호출 및 필드 변경 ===========");
		Class clazz14 = Class.forName("reflectiontest.StaticExample");
		Method method = clazz14.getDeclaredMethod("getSquare", int.class);
		method.invoke(null, 10);

		// static 필드 정보를 가져오는 방법도 위와 동일하다.
		// 대신 set() 또는 get()함수를 사용할 때 객체로 전달되는 인자에 null을 넣어야 한다.
		Class clazz15 = Class.forName("reflectiontest.StaticExample");
		Field fld = clazz15.getDeclaredField("EXAMPLE");
		fld.set(null, "Hello, World");
		System.out.println("StaticExample.EXAMPLE: " + fld.get(null));
	}
}
