package myy803.eaap.tablemodulegateway.example.modules;

import java.sql.ResultSet;
import java.sql.SQLException;

import myy803.eaap.tablemodulegateway.example.gateways.StopGateway;

public class StopModule {
	
	public void setStopStatus(int stopId, int status) {
			StopGateway stopGateway = new StopGateway();
			
			try {
				ResultSet rSet = stopGateway.findStopsById(stopId);
				if(rSet.next()) {
					stopGateway.updateStop(
							stopId,
							rSet.getString("name"),
							status,
							rSet.getDouble("latitude"),
							rSet.getDouble("longtitude"),
							rSet.getInt("route_id")
						);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	
	public String reportStopStatus(int stopId) {
		String statusReport = "";
		StopGateway stopGateway = new StopGateway();

		try {
			ResultSet rSet = stopGateway.findStopsById(stopId);
			while(rSet.next()) {
				int stopStatus = rSet.getInt("status");
				if(stopStatus == StopGateway.STOP_STATUS_OK)
					statusReport = "Bus stop " + stopId + " is FUNCTIONAL";
				else 
					statusReport = "Bus stop " + stopId + " is CLOSED";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return statusReport;
	}
}
