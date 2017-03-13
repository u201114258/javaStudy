package enumStudy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GenderTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Gender g = Gender.FEMALE;
//		g.name = "女";//The field Gender.name is not visible
		System.out.println(g + "代表" + g.getName());
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "a");
		map.put(2, "b");
		Iterator<?> it = map.entrySet().iterator();
		Map.Entry<Integer, String> ent = null;
		while (it.hasNext()){
			ent = (Entry<Integer, String>) it.next();
			System.out.println(ent.getKey() + ":" + ent.getValue());
		}
		for (Map.Entry<Integer, String> ent2 : map.entrySet()){
			System.out.println(ent2.getKey() + "=" + ent2.getValue());
		}
	}
}
