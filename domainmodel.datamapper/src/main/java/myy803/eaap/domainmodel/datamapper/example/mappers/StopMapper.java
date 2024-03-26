package myy803.eaap.domainmodel.datamapper.example.mappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myy803.eaap.domainmodel.datamapper.example.domainmodel.Stop;

public class StopMapper {

	public void saveStop(Stop stop){
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			
			PreparedStatement stm = connection.prepareStatement("INSERT INTO stops VALUES (?, ?, ?, ?, ?, ?)");
			stm.setInt(1, stop.getId());
			stm.setString(2, stop.getName());
			stm.setDouble(4, stop.getLongtitude());
			stm.setDouble(5, stop.getLatitude());
			stm.setInt(3, stop.getStatus());
			stm.setInt(6, stop.getRouteId());

			stm.executeUpdate();	
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStop(Stop stop){
		try {
			Connection connection;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			
			PreparedStatement stm = connection.prepareStatement("DELETE FROM stops WHERE id = ?");			
			stm.setInt(1, stop.getId());
			
			stm.executeUpdate();	

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStop(Stop stop) {
		try {
			Connection connection;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			
			PreparedStatement stm = connection.prepareStatement("UPDATE stops "
					+ "SET name = ?, "
					+ "status = ?, "
					+ "longtitude = ?, "
					+ "latitude = ?, "
					+ "route_id = ? "
					+ "WHERE id = ?");
			
			stm.setInt(1, stop.getId());
			stm.setString(2, stop.getName());
			stm.setInt(3, stop.getStatus());
			stm.setDouble(4, stop.getLongtitude());
			stm.setDouble(5, stop.getLatitude());
			
			stm.executeUpdate();	

			connection.close();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Stop findStopById(int stopId) throws SQLException {		
		Stop stop = null;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
		
		PreparedStatement stm = connection.prepareStatement("SELECT * FROM stops WHERE id = ?");
		stm.setInt(1, stopId);
		ResultSet rs = stm.executeQuery();
		
		if(rs.next()) {
			stop = new Stop(
					rs.getInt("id"), rs.getString("name"),
					rs.getDouble("latitude"), rs.getDouble("longtitude"),
					rs.getInt("status"), rs.getInt("route_id")
					);
		}
		
		return stop;
	}
	
	public List<Stop> findStopsByRouteId(int routeId) throws SQLException {
		List<Stop> stops = new ArrayList<Stop>();
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");

		PreparedStatement stm = connection.prepareStatement("SELECT * FROM stops WHERE route_id = ?");
		stm.setInt(1, routeId);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()) {
			stops.add(
				new Stop(
					rs.getInt("id"), rs.getString("name"),
					rs.getDouble("latitude"), rs.getDouble("longtitude"),
					rs.getInt("status"), rs.getInt("route_id"))
				);
		}
		
		return stops;
	}
}