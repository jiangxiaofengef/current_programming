package ch4;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PublishingVehicleTracker {
	private final Map<String, SafePoint> locations;
	private final Map<String, SafePoint> unmodifiableMap;
	
	public PublishingVehicleTracker(Map<String, SafePoint> map) {
		this.locations = new ConcurrentHashMap<String, SafePoint>(map);
		this.unmodifiableMap = Collections.unmodifiableMap(locations);
	}
	
	public Map<String, SafePoint> getLocations() {
		return unmodifiableMap;
	}
	
	public SafePoint getLocation(String id) {
		return locations.get(id);
	}
	
	public void setLocation(String id, int x, int y) {
		if (!locations.containsKey(id)) {
			throw new IllegalArgumentException("No such ID: " + id);
		}
		
		locations.get(id).set(x, y);
	}
}

class SafePoint {
	private int x, y;
	
	private SafePoint(int[] a) {
		this(a[0], a[1]);
	}
	
	public SafePoint(SafePoint p) {
		this(p.get());
	}
	
	public SafePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public synchronized int[] get() {
		return new int[] {x, y};
	}
	
	public synchronized void set(int x, int y) {
		this.x = x; 
		this.y = y;
	}
}
