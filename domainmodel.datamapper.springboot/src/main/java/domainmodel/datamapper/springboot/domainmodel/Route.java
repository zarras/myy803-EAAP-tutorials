package domainmodel.datamapper.springboot.domainmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "routes")
public class Route {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="route_id")
	private List<Stop> stops = new ArrayList<Stop>();
	
	
	public Route() {
		super();
	}


	public Route(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public String reportStatus() {
		String statusReport = "";
		
		for(Stop stop : stops)
			statusReport += stop.reportStatus() + " ";			
		
		return statusReport;	
	}
	
}