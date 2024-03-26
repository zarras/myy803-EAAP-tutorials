package domainmodel.datamapper.springboot.domainmodel;

import jakarta.persistence.*;

@Entity
@Table(name = "stops")
public class Stop {
	public static final int STOP_STATUS_OK = 0;
	public static final int STOP_STATUS_CLOSED = 1;

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "latitude")
	private double latitude;
	@Column(name = "longtitude")
	private double longtitude;
	@Column(name = "status")
	private int status;
	
	
	public Stop() {
		super();
	}

	public Stop(int id, String name, double latitude, double longtitude, int status) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.status = status;
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

	public static int getStopStatusOk() {
		return STOP_STATUS_OK;
	}

	public static int getStopStatusClosed() {
		return STOP_STATUS_CLOSED;
	}

	
}
