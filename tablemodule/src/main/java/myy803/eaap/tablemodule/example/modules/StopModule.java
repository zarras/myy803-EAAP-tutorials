package myy803.eaap.tablemodule.example.modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StopModule {
	public static final int STOP_STATUS_OK = 0;
	public static final int STOP_STATUS_CLOSED = 1;

	public void saveStop(int stopId, String name, 
			double longtitude, double latitude, int status, int routeId){
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			
			PreparedStatement stm = connection.prepareStatement("INSERT INTO stops VALUES (?, ?, ?, ?, ?, ?)");
			stm.setInt(1, stopId);
			stm.setString(2, name);
			stm.setInt(3, status);
			stm.setDouble(4, longtitude);
			stm.setDouble(5, latitude);
			stm.setInt(6, routeId);

			stm.executeUpdate();	
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStop(int stopId){
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			
			PreparedStatement stm = connection.prepareStatement("DELETE FROM stops WHERE id = ?");			
			stm.setInt(1, stopId);
			
			stm.executeUpdate();	

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setStopStatus(int stopId, int status) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			PreparedStatement stm = connection.prepareStatement("UPDATE stops SET status = ? WHERE id = ?");
			stm.setInt(1, status);
			stm.setInt(2, stopId);
			
			stm.executeUpdate();	

			connection.close();	

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String reportStopStatus(int stopId) {
		String statusReport = "";
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			
			PreparedStatement stm = connection.prepareStatement("SELECT status FROM stops WHERE id = ?");
			stm.setInt(1, stopId);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				int stopStatus = rs.getInt("status");
				if(stopStatus == StopModule.STOP_STATUS_OK)
					statusReport = "Bus stop " + stopId + " is FUNCTIONAL";
				else 
					statusReport = "Bus stop " + stopId + " is CLOSED";
			}
			
			connection.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return statusReport;
	}
	
	public ResultSet findStopsByRouteId(int routeId) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
		PreparedStatement stm = connection.prepareStatement("SELECT * FROM stops WHERE route_id = ?");
		stm.setInt(1, routeId);
		ResultSet rs = stm.executeQuery();

		return rs;
	}
}
