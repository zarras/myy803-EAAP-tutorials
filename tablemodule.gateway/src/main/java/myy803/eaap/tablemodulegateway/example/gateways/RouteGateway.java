package myy803.eaap.tablemodulegateway.example.gateways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteGateway {
	
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

			StopGateway stopGateway = new StopGateway();
			ResultSet rs = stopGateway.findStopsByRouteId(routeId);

			while (rs.next()) {
				int stopId = rs.getInt("id");
				stopGateway.deleteStop(stopId);
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
	
}
