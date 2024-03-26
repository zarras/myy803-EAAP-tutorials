package myy803.eaap.domainmodel.datamapper.example.domainmodel;

import java.util.Collections;
import java.util.List;

public class Route {
	private int id;
	private String name;
	private List<Stop> stops;
		
	public Route(int id, String name, List<Stop> stops) {
		super();
		this.id = id;
		this.name = name;
		this.stops = stops;
	}

	public String reportStatus() {
		String statusReport = "";
		
		for(Stop stop : stops)
			statusReport += stop.reportStatus() + " ";			
		
		return statusReport;	
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Stop> getStops() {
		return Collections.unmodifiableList(stops);
	}

	public void addStop(Stop stop) {
		stops.add(stop);
	}
}