package ch4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DelegatingVehicleTracker {
	private final ConcurrentHashMap<String, Point> locations;
	private final Map<String, Point> unmodifiableMap;
	
	public DelegatingVehicleTracker(Map<String, Point> points) {
		locations = new ConcurrentHashMap<String, Point>(points);
		unmodifiableMap = Collections.unmodifiableMap(points);
	}
	
	public Map<String, Point> getRealTimeLocations() {
		return unmodifiableMap;
	}
	
	public Map<String, Point> getStaticLocations() {
		return Collections.unmodifiableMap(new HashMap<String, Point>(locations));
	}
	
	public Point getLocation(String id) {
		return locations.get(id);
	}
	
	public void setLocation(String id, int x, int y) {
		if (locations.replace(id, new Point(x, y)) == null) {
			throw new IllegalArgumentException("No such ID: " + id);
		}
	}
}

class Point {
	public final int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
