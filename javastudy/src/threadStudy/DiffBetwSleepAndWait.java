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
			Thread.sleep(2000);
//			this.wait(2000);
			number *= 20;
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
		th.start();
		dbsaw.secondMethod();
	}
}
