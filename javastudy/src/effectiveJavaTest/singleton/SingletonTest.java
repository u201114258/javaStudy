package effectiveJavaTest.singleton;


public class SingletonTest {

	public static void main(String[] args){
		SingletonHungry a = SingletonHungry.getInstance();
		SingletonHungry b = SingletonHungry.getInstance();
		System.out.println(a == b);
		SingletonInnerClass c = SingletonInnerClass.getInstance();
		SingletonInnerClass d = SingletonInnerClass.getInstance();
		System.out.println(c == d);
		SingletonLazy e = SingletonLazy.getInstance();
		SingletonLazy f = SingletonLazy.getInstance();
		System.out.println(e == f);
		SingletonEnum g = SingletonEnum.SINGLETON;
		SingletonEnum h = SingletonEnum.SINGLETON;
		System.out.println(g == h);
	}
}
