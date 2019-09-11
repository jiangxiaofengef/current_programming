package ch3;

public class UnsafePublisher {
	public Holder holder;
	
	public void initialize() {
		System.out.println("initialize holder!");
		holder = new Holder(42);
	}
	
	public static void main(String[] args) {
		UnsafePublisher unsafePublisher = new UnsafePublisher();
		UnsafePublisherThread unsafePublisherThread = new UnsafePublisherThread(unsafePublisher);
		unsafePublisherThread.start();
		unsafePublisher.initialize();
	}
}

class Holder {
	private int n;
	
	public Holder(int n) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.n = n;
	}
	
	public void printN() {
		System.out.println(n);
	}
}

class UnsafePublisherThread extends Thread {
	 UnsafePublisher unsafePublisher;
	
	public UnsafePublisherThread(UnsafePublisher unsafePublisher) {
		this.unsafePublisher = unsafePublisher;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		unsafePublisher.holder.printN();
	}
}

