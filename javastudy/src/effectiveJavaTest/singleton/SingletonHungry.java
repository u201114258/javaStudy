package effectiveJavaTest.singleton;

public class SingletonHungry {

	private static SingletonHungry singleton = new SingletonHungry();
	private SingletonHungry(){}
	public static SingletonHungry getInstance(){
		return singleton;
	}
}

//以下是变种，使用final关键字来修饰也能使构造函数只调用一次
//public class SingletonHungry {
//	public static final SingletonHungry singleton = new SingletonHungry();
//	private SingletonHungry(){}
//}