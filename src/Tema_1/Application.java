package Tema_1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {			
				try {
					Producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {			
				try {
					Consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
	private static void Producer() throws InterruptedException{
		Random random = new Random();
		
		while(true){
			Thread.sleep(100);
			queue.put(random.nextInt(100));
		}
	}
	
	private static void Consumer() throws InterruptedException{
		Random random = new Random();
		
		while(true){
			Thread.sleep(101);
			
			//if (random.nextInt(1) == 0){
				Integer value = queue.take();
				
				System.out.println("Variabila extrasa: " + value + " Domensiune cozii: "+ queue.size());
			//}
		}
	}
}
