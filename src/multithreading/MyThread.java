package multithreading;

public class MyThread extends Thread {

	public void run() {
		System.out.println("First Thread running");
	}

	public static void main(String args[]) throws InterruptedException {
		MyThread thread1 = new MyThread();
		thread1.start();

		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("Second Thread Running");
			}
		};
		thread2.start();

		Runnable runnable2 = new Runnable() {
			public void run() {
				System.out.println("creating thread using anonymous Runnable");
			}
		};
		Thread thread3 = new Thread(runnable2);
		thread3.start();

		Runnable runnable3 = () -> {
			System.out.println("creating thread using Lambda Runnable");
		};
		Thread thread4 = new Thread(runnable3);
		thread4.start();

		Runnable runnable = new MyRunnable();
		Thread thread5 = new Thread(runnable);
		thread5.start();

		// set name
		thread5.setName("My Thread");

	}
}

class MyRunnable implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName() + " creating thread using runnable interface");
	}
}
