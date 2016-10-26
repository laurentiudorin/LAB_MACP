package Tema_0;

public class Application {
	
	private volatile int numar = 0;
	
	
	public synchronized void aduna(){
		numar++;
	}
	
	public static void main(String[] args) {
		
		Application app = new Application();
		app.work();	
	}
	
	public void work(){
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					aduna();
					//numar++;
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					aduna();
					//numar++;
				}
			}
		});
	
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Numarul este: " + numar);
	}
}
