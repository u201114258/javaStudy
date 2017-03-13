package effectiveJavaTest.singleton;

public class SingletonInnerClass {

	private static final class innerInstance{
		private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
	}
	
	private SingletonInnerClass(){}
	
	public static SingletonInnerClass getInstance(){
		return SingletonInnerClass.innerInstance.INSTANCE;
	}
}
/*
 * 为什么内部类的实现方式是更佳的方式呢？由于jvm的classloader机制当用户自己编写的class需要调用时才装载，前面的
 * 饿汉式是当这个SingletonHungry被加载时就进行实例化（调用私有的构造函数），也就是说就算没有调用SingletonHungry的getInstance()
 * 方法也会去做，有可能会浪费资源。这里使用内部类的话，当且仅当调用调用getInstance()方法时才会调用，并且也是线程安全的
 */