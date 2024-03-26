package myy803.eaap.tablemodulegateway.example.modules;

import java.sql.ResultSet;
import java.sql.SQLException;

import myy803.eaap.tablemodulegateway.example.gateways.StopGateway;

public class RouteModule {
	
	public String reportRouteStatus(int routeId) {
		String statusReport = "";
		try {
			StopGateway stopGateway = new StopGateway();
			StopModule stopModule = new StopModule();
			
			ResultSet rs = stopGateway.findStopsByRouteId(routeId);			
			
			while (rs.next()) {
				int stopId = rs.getInt("id");
				statusReport += stopModule.reportStopStatus(stopId) + " ";			
			}	
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return statusReport;	
	}
	
}
