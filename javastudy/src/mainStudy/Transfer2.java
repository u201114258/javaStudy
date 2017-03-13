package mainStudy;
class DataWrap implements Cloneable
{
	int a;
	int b;
	
	public Object Clone(){
		DataWrap dw = null;
		try{
			dw = (DataWrap)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		
		return dw;
	} 
}
public class Transfer2
{
	public static void swap(DataWrap dw)
	{
		int tmp = dw.a;
		dw.a = dw.b;
		dw.b = tmp;
		System.out.println(dw.a+","+dw.b);
	}
	public static void main(String[] args){
		DataWrap dw = new DataWrap();
		dw.a = 6;
		dw.b = 9;
		swap((DataWrap)dw.Clone());//use clone to protect the former parm;
		System.out.println(dw.a+","+dw.b);
	}//the parameter here is the address!!!!
}