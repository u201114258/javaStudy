import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {

	public static void main(String[] args){
//		int [][] a = {{}};//a.length = 1
		/************************************************************************/
//		ArrayList<String> al = new ArrayList<String>();
//		al.add("a");
////		String[] a = new String[2];
////		al.toArray(a);
//		String str = "1";
//		
//		doSomething(al, str);
//		
//		int length = al.size();
//		for (int i = 0;i < length;i++){
//			System.out.println(al.get(i));//List的index是从0开始的!!
//		}
//		System.out.println(str);
//		//result:a b 1
		/************************************************************************/
//		testPoints("I love my job.");//一个参数传入  
//        testPoints("you","and","me");//3个String参数传入  
//        testPoints(new String[]{"you","and","me"});//同上
        /************************************************************************/
//        int[][] a = new int[][]{{1,4},{2,7},{8,10},{9,13}};
//        System.out.println(Find(a,9));
        /************************************************************************/
//		List<String> a = new ArrayList<String>(); 
//		a.add("1");
//		a.add("2");
//		a.add("3");
//		a.add("4");
//		for (String temp : a) { 
//			if ("3".equals(temp)){ //当且仅当3为倒数第二个的时候不抱错
//				a.remove(temp); 
//				} 
//			}
//		System.out.println(a.toString());
		
		/***********************************************************************/
		Map<Integer,String> testmap = new HashMap<Integer,String>();
		testmap.put(1, "a");
		testmap.put(2, "b");
//		for (Map.Entry<Integer, String> entry : testmap.entrySet()){
//			System.out.println("key:" + entry.getKey() + " and value:" + entry.getValue());
//		}
		System.out.println(testmap.get(3));
	}
	
	public static void testPoints(String... s){  
        if(s.length==0){  
            System.out.println("没有参数传入！");  
        }else if(s.length==1){  
            System.out.println("1个参数传入！");  
        }else{      
            System.out.println("the input string is-->");  
            for(int i=0;i<s.length;i++){  
                System.out.println("第"+(i+1)+"个参数是"+s[i]+";");  
            }      
            System.out.println();  
        }  
    }  
	
	public static void doSomething(ArrayList<String> al,String str){
		al.add("b");
		str = str.replace("1", "2");
		System.out.println("In doSomething method: str = " + str);
		al = new ArrayList<String>();
		al.add("c");
	}
	
	public static boolean Find(int [][] array,int target) {
		int len = array.length-1;
		int i = 0;
		while((len >= 0)&& (i < array[0].length)){
			if(array[len][i] > target){
				len--;
			}else if(array[len][i] < target){
				i++;
			}else{
              return true;
            }
		}
		return false;
	}
}
