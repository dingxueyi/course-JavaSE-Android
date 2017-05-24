package lww.class22;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException{
		Person person = new Person();
		person.setName("Mary");
		
		System.out.println(person.getClass());
		//�õ�������������
		Class className = person.getClass();
		//�õ����е�����
		Field[] fields = className.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		//�õ����еķ���
		Method[] methods = className.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println(className.getMethod("print", null));
		System.out.println(className.getMethod("setName", String.class));
	}
}
class Person{
	private String name;
	public int age=20;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void print(){
		System.out.println("name:" + name +"\nage:" + age);
	}
}