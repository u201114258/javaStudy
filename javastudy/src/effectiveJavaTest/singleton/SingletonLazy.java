package effectiveJavaTest.singleton;
//缺点：线程不安全
public class SingletonLazy {

	private static SingletonLazy singleton = null;//不加staic会报错
	private SingletonLazy(){}
	public static final SingletonLazy getInstance(){
		if (singleton == null){
			singleton = new SingletonLazy();
		}
		return singleton;
	}
}


/*//缺点：每次都要对getInstance加锁，有资源浪费
public class SingletonLazy{
	private static SingletonLazy singleton = null;
	private SingletonLazy(){
		
	}
	public static final synchronized SingletonLazy getInstance(){
		//此方法与上面最大的区别就在于使用了关键字synchronized
		if (singleton == null){
			singleton = new SingletonLazy();
		}
		return singleton;
	}
}*/
