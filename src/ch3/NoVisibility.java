package ch3;

//需要 jvm 运行在server模式下
public class NoVisibility {
	private static int number;
	
	private static class ReaderThread extends Thread {
		boolean ready = false;
		
		@Override
		public void run() {
			while(!ready) {
				number++;
			}
			
			System.out.println(number);
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		ReaderThread readerThread = new ReaderThread();
		readerThread.start();
		Thread.sleep(2000);
		readerThread.ready = true;
		System.out.print(readerThread.ready);
		
	}
}
