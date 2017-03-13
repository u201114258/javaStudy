package sortStudy;

public class SortTest {

	public static void main(String[] args){
		SortUtil su = new SortUtil();
		int[] array = {8,6,5,9,7,2,3,1,0,5};
//		su.buddleSort(array);
//		su.mergeSort(array);
		su.quickSort(0, 9, array);
		for (int i : array){
			System.out.println(i + ",");
		}
	}
}
