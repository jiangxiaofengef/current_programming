package ch4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MonitorVehicleTracker {
	private final Map<String, MutablePoint> locations;
	
	public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
		this.locations = locations;
	}
	
	public synchronized Map<String, MutablePoint> getLocations() {
		return deepCopy(locations);
	}
	
	public synchronized MutablePoint getLocation(String id) {
		MutablePoint loc = locations.get(id);
		return loc == null ? null : new MutablePoint(loc);
	}
	
	public synchronized void setLocation(String id, int x, int y) {
		MutablePoint loc = locations.get(id);
		
		if (loc == null) {
			throw new IllegalArgumentException("No such ID: " + id);
		}
		
		locations.put(id, new MutablePoint(x, y));
	}
	
	private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
		Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();
		
		for (String id : m.keySet()) {
			result.put(id, new MutablePoint(m.get(id)));
		}
		
		return Collections.unmodifiableMap(result);
	}
}

class MutablePoint {
	public int x, y;
	
	public MutablePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public MutablePoint(MutablePoint loc) {
		this.x = loc.x;
		this.y = loc.y;
	}
	
}
