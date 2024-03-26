package myy803.eaap.tablemodulegateway.example.gateways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StopGateway {
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
	
	public void updateStop(int stopId, String name, int status, 
			double latitude, double longtitude, int routeId) {
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			
			PreparedStatement stm = connection.prepareStatement("UPDATE stops "
					+ "SET name = ?, "
					+ "status = ?, "
					+ "longtitude = ?, "
					+ "latitude = ?, "
					+ "route_id = ? "
					+ "WHERE id = ?");
			
			stm.setString(1, name);
			stm.setInt(2, status);
			stm.setDouble(3, latitude);
			stm.setDouble(4, longtitude);
			stm.setInt(5, routeId);
			stm.setInt(6, stopId);

			stm.executeUpdate();	

			connection.close();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet findStopsById(int stopId) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
		
		PreparedStatement stm = connection.prepareStatement("SELECT * FROM stops WHERE id = ?");
		stm.setInt(1, stopId);
		ResultSet rs = stm.executeQuery();
			
		return rs;
	}
	
	public ResultSet findStopsByRouteId(int routeId) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");

		PreparedStatement stm = connection.prepareStatement("SELECT * FROM stops WHERE route_id = ?");
		stm.setInt(1, routeId);
		ResultSet rs = stm.executeQuery();
		
		return rs;
	}
}