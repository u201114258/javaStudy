package queueStudy;


public class ArrayQueue {

	private int[] array = new int[10];//初始大小为10
	private int size = 10;
	private int num = 0;//用来记录队列中的元素个数，便于判断队列是否为空
	private int top = 0;
	private int bottom = 0;
	public void push(int x){
		if (num == size){
			System.out.println("队列已满，不能插入！");
			return;
		}
		array[top++] = x;
		if (top == size){
			top = 0;
		}
		num ++;
	}
	public int pop(){
		if (num < 1){
			System.out.println("队列为空，不能弹出！");
			return -1;
		}
		num --;
		if (bottom == size - 1){
			int value = array[bottom];
			bottom = 0;
			return value;
		}
		return array[bottom++];
	}
	public ArrayQueue(int size){
		this.size = size;
		array = new int[size];
	}
	public String toString(){
		String result = "";
		int start = bottom;
		for (int i = 0; i < num;i++){
			result += array[(start + i) % size];
		}
		return result;
	}
}
