package classstudy;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ExtendedObjectPoolFactory {
	
	private Map<String,Object> objectPool = new HashMap();
	private Properties config = new Properties();
	
	//读取文件
	public void init(String fileName){
		try(FileInputStream fis = new FileInputStream(fileName)){
			config.load(fis);
		}
		catch(IOException ex){
			System.out.println("读取" + fileName + "异常");
		}
	}
	
	//创建对象
	private Object createObject(String clazzName) 
			throws InstantiationException,IllegalAccessException,ClassNotFoundException{
		
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}
	
	//初始化对象池
	public void initPool() 
			throws InstantiationException,IllegalAccessException,ClassNotFoundException{
		for (String name : config.stringPropertyNames()){
			if(!name.contains("%")){
				objectPool.put(name, createObject(config.getProperty(name)));
			}
		}
	}
	
	//取setter方法
	public void initProperty() 
			throws InvocationTargetException,IllegalAccessException,NoSuchMethodException{
		for (String name : config.stringPropertyNames()){
			if (name.contains("%")){
				
				String[] objAndProp = name.split("%");
				Object target = getObject(objAndProp[0]);
				String mtdName = "set" + objAndProp[1].substring(0, 1).toUpperCase() +
						objAndProp[1].substring(1);
				Class<?> targetClass = target.getClass();
				
				Method mtd = targetClass.getMethod(mtdName, String.class);
				mtd.invoke(target, config.getProperty(name));
			}
		}
	}
	public Object getObject(String name){
		return objectPool.get(name);
	}
	public static void main(String[] args) 
			throws Exception{
		ExtendedObjectPoolFactory epf = new ExtendedObjectPoolFactory();
		epf.init("extObj.txt");
		epf.initPool();
		epf.initProperty();
		System.out.println(epf.getObject("a"));
	}
}
