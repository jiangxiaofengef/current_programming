package ch1;

public class UnsafeSequence {
	private int value;
	
	public int getNext() {
		return value++;
	}
}
