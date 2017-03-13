package sortStudy;

public class SortUtil {

	//交换
	public void swap(int i,int j,int[] array){
		int value = array[i];
		array[i] = array[j];
		array[j] = value;
	}
	
	//冒泡排序
	public void buddleSort(int[] args){
		int length = args.length;
		for (int i = 0;i < length;i++){
			for (int j = 0;j < length - 1 - i;j++){
				if (args[j] > args[j + 1]) swap(j,j + 1,args);
			}
		}
	}
/*************************************************************************/
	//归并排序
	public void mergeSort(int[] args){
		int length = args.length;
//		if (length == 1) return;
		if (length == 1){
			return;
		} else{
			int[] array1 = new int[length/2];
			int[] array2 = new int[length - length/2];
			for (int i = 0; i < length/2;i++){
				array1[i] = args[i];
			}
			for (int j = length/2; j < length;j++){
				array2[j - length/2] = args[j];
			}
			this.mergeSort(array1);
			this.mergeSort(array2);
			
			int i = 0;
			int j = 0;
			for (int k = 0;k < length;k++){
				if (i < length/2 && j < length - length/2){
					args[k] = array1[i] <= array2[j]? array1[i++] : array2[j++];
				} else if (i == length/2){
					args[k] = array2[j++];
				} else {
					args[k] = array1[i++];
				}
			}
		}
	}
/**************************************************************/
	//划分
	public int partition(int start,int end,int[] args){
		while(start < end){
			while(start < end && args[start] <= args[end]) end--;
			swap(start,end,args);
			while(start < end && args[start] <= args[end]) start++;
			swap(start,end,args);
		}
		return start;
	}
	
	//快速排序
	public void quickSort(int start,int end,int[] args){
		if (start < end){
			int location = partition(start,end,args);
			if (location == start || location == end){
				if (location == start) quickSort(location + 1,end,args);
				if (location == end) quickSort(start,location - 1,args);
			} else{
				quickSort(start,location - 1,args);
				quickSort(location + 1,end,args);
			}
		}
		return;
	}
/**************************************************************************/
}
