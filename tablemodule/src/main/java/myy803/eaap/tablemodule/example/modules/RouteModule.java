package myy803.eaap.tablemodule.example.modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteModule {
	
	public void saveRoute(int routeId, String name) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");

			PreparedStatement stm = connection.prepareStatement("INSERT INTO routes VALUES (?, ?, null, null)");
			stm.setInt(1, routeId);
			stm.setString(2, name);
			
			stm.executeUpdate();	
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRoute(int routeId){
		try {

			StopModule stopModule = new StopModule();
			ResultSet rs = stopModule.findStopsByRouteId(routeId);

			while (rs.next()) {
				int stopId = rs.getInt("id");
				stopModule.deleteStop(stopId);
			}
			rs.close();
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			PreparedStatement stm = connection.prepareStatement("DELETE FROM routes WHERE id = ?");			
			stm.setInt(1, routeId);
		
			stm.executeUpdate();	

			connection.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String reportRouteStatus(int routeId) {
		String statusReport = "";
		try {
			StopModule stopModule = new StopModule();
			ResultSet rs = stopModule.findStopsByRouteId(routeId);			
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
