package classstudy;

public class CloneTest implements Cloneable{
	private String name;
	
	public Object clone(){
		CloneTest clonetest = null;
		try{
			clonetest = (CloneTest)super.clone();
		} catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return clonetest;
	}
	@Override
	public boolean equals(Object o){
		if(!(o instanceof CloneTest))
			return false;
		CloneTest ct = (CloneTest)o;
		return name==null?ct.name==null:name.equals(ct.name);//to void NullPointerException
	}
	@Override
	public int hashCode(){
		int result = 17;
		result = result * 31 + name.hashCode();
		return result;
	}//beautiful code!
	
	public static void main(String[] args){
		CloneTest a = new CloneTest();
		CloneTest b = new CloneTest();
		
		a.name = "cc";
		b = (CloneTest) a.clone();
		System.out.println(a==b);//false
		//false because of the difference of the hashcode
		System.out.println(b.equals(a) + "," + a.hashCode() + "," + b.hashCode());
//		b = a;
//		System.out.println(a==b);//true
//		System.out.println(a.equals(b) + "," + a.hashCode() + "," + b.hashCode());
		b.name = "curry";
		
		System.out.println("a.name = " + a.name);
		System.out.println("b.name = " + b.name);
	}
}
