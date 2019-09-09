package ch1;

public class TestUnsafeSequence extends Thread{
	UnsafeSequence unsafeSequence;
	
	public TestUnsafeSequence(UnsafeSequence unsafeSequence) {
		this.unsafeSequence = unsafeSequence;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + unsafeSequence.getNext());
		}
	}

	//���̷߳���ͬһʵ��,������ɳ��̲߳���ȫ
	public static void main(String[] args) {
		UnsafeSequence unsafeSequence = new UnsafeSequence();
		Thread thread1 = new TestUnsafeSequence(unsafeSequence); 
		Thread thread2 = new TestUnsafeSequence(unsafeSequence); 
		thread1.start();
		thread2.start();
	}
}
