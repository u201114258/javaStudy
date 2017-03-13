package queueStudy;

public class ArrayQueueTest {

	public static void main(String[] args){
		int size = 3;
		ArrayQueue aq = new ArrayQueue(size);
		aq.push(1);
		aq.push(2);
		aq.push(3);
		aq.push(4);
		System.out.println(aq.toString());
		System.out.println(aq.pop());
		aq.push(4);
		System.out.println(aq.toString());
	}
}
