package ch4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VisualComponent {
	private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<KeyListener>();
	private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<MouseListener>();
	
	public void addKeyListener(KeyListener keyListener) {
		keyListeners.add(keyListener);
	}
	
	public void addMouseListener(MouseListener mouseListener) {
		mouseListeners.add(mouseListener);
	}
	
	public void removeKeyListener(KeyListener keyListener) {
		keyListeners.remove(keyListener);
	}
	
	public void removeMouseListener(MouseListener mouseListener) {
		mouseListeners.remove(mouseListener);
	}
}

class KeyListener {
	
}

class MouseListener {
	
}
