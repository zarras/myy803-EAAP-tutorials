package myy803.eaap.domainmodel.datamapper.example.domainmodel;

public class Stop {
	public static final int STOP_STATUS_OK = 0;
	public static final int STOP_STATUS_CLOSED = 1;

	private int id;
	private String name;
	private double latitude;
	private double longtitude;
	private int status;
	private int routeId;
	
	public Stop(int id, String name, double latitude, double longtitude, int status, int routeId) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.status = status;
		this.routeId = routeId;
	}

	public String reportStatus() {
		String statusReport = "";

		if(status == STOP_STATUS_OK)
			statusReport = "Bus stop " + id + " is FUNCTIONAL";
		else if(status == STOP_STATUS_CLOSED) {
			statusReport = "Bus stop " + id + " is CLOSED";
		} 
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


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongtitude() {
		return longtitude;
	}


	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	
}
