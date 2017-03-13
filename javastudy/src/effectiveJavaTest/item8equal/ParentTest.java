package effectiveJavaTest.item8equal;

public class ParentTest {
	public static void main(String[] args){
		Person cc = new Person("陈忱",22);
		
//		Parent wsm = (Parent) new Person("陈忱",22);
//		System.out.println(cc.equals(wsm));  java.lang.ClassCastException
		
		Parent wsm = new Parent("陈忱",22,cc);
		Person rick = new Person();
//		System.out.println(rick.equals(wsm)); //空指针
		System.out.println(wsm.equals(cc));//false
		System.out.println(cc.equals(wsm));//ture
	}
}
