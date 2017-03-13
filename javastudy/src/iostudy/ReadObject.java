package iostudy;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ReadObject {

	public static void main(String[] args){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt")))
		{
			Person p = (Person)ois.readObject();
			System.out.println("The name is "+p.getName()+"and the age is "+p.getAge());
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
