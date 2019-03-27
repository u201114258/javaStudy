package threadStudy;

public class DiffBetwSleepAndWait implements Runnable{

	int number = 10;
	
	public void firstMethod(){
		synchronized (this){
			number += 100;
			System.out.println(number);
		}
	}
	
	public void secondMethod() throws InterruptedException{
		synchronized(this){
//			Thread.sleep(2000);//Causes the currently executing thread to sleep(main thread and Jvm thread running the firstMehod)
//			this.wait(2000);//Causes the current thread to wait(only main thread)
			number *= 20;
			System.out.println(number);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.firstMethod();
	}

	public static void main(String[] args) throws InterruptedException{
		DiffBetwSleepAndWait dbsaw = new DiffBetwSleepAndWait();
		Thread th = new Thread(dbsaw);
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time:" + startTime);
		th.start();
		/*
		The result is that two threads are running concurrently: the
     * current thread (which returns from the call to the
     * <code>start</code> method) and the other thread (which executes its
     * <code>run</code> method).
		 */
		dbsaw.secondMethod();
		long endTime = System.currentTimeMillis();
		System.out.println("End Time:" + endTime);
		System.out.println("End - Start = " + (endTime - startTime));
	}
}
