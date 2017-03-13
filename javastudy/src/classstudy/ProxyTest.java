package classstudy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Person{
	void walk();
	void sayHello(String name);
}
class MyInvokationHandler implements InvocationHandler{
	public Object invoke(Object proxy,Method method,Object[] args){
		System.out.println("-----The menthod executing is :" + method);
		if (args != null){
			System.out.println("The parameters of the method are:");
			for (Object val:args){
				System.out.println(val);
			}
		}else{
			System.out.println("No parameter is found from the method!");
		}
		return null;
	}
}
public class ProxyTest {
	public static void main(String[] args) throws Exception{
		InvocationHandler handler = new MyInvokationHandler();
		Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),
				new Class[]{Person.class}, handler);
		
		p.walk();
		p.sayHello("cc");
	}
}
