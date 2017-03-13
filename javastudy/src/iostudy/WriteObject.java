package iostudy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class Person implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	public Person(String name,int age){
		System.out.println("constructor with parameters!");
		this.name = name;
		this.age = age;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
}
public class WriteObject
{
	public static void main(String[] args){
		//这个括号在JDK1.7之前是没有的，是1.7的新特性。
		//括号里的内容支持包括流以及任何可关闭的资源，数据流会在 try 执行完毕后自动被关闭，而不用我们手动关闭了
		File fileExcelsBak = new File("D:\\file\\object.txt");
		
		if(!fileExcelsBak.exists()){
//			fileExcelsBak.mkdir();
			File dir = new File("D:\\file");
			dir.mkdir();
//			fileExcelsBak = new File(dir,"object.txt");
			try {
				fileExcelsBak.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//					fileExcelsBak.
		}
		try(
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileExcelsBak));
			FileOutputStream fs = new FileOutputStream(fileExcelsBak);
		){
			Person per = new Person("陈忱",23);
			oos.writeObject(per);
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
