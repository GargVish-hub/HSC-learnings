package multithreading;

public class Synchronization {
	
	 public static void main(String[] args){
	      Counter counter = new Counter();
	      Thread  thread1 = new CounterThread(counter);
	      Thread  thread2 = new CounterThread(counter);
	      
	      Thread thread3 = new Thread() {
				public void run() {
					for(int i =0; i< 10; i++)
				    	counter.add();
				}
			};

	      thread1.start();
	      thread2.start();
	      thread3.start();
	    }
}

class Counter{
    long count = 0;
   
    public synchronized void add(){
      this.count++;
      System.out.println(count);
    }
 }

class CounterThread extends Thread{

    Counter counter = null;
    public CounterThread(Counter counter){
       this.counter = counter;
    }

    public void run() {
    	for(int i =0; i< 10; i++)
    	counter.add();
    }
 }