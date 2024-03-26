package myy803.eaap.domainmodel.datamapper.example.mappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import myy803.eaap.domainmodel.datamapper.example.domainmodel.Route;
import myy803.eaap.domainmodel.datamapper.example.domainmodel.Stop;

public class RouteMapper {
	
	public void saveRoute(Route route) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");

			PreparedStatement stm = connection.prepareStatement("INSERT INTO routes VALUES (?, ?, null, null)");
			stm.setInt(1, route.getId());
			stm.setString(2, route.getName());
			stm.executeUpdate();	
			connection.close();
			
			StopMapper sMapper = new StopMapper();
			List<Stop> stops = route.getStops();
			for(Stop stop : stops) {
				sMapper.saveStop(stop);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRoute(Route route){
		try {
			StopMapper sMapper = new StopMapper();
			List<Stop> stops = route.getStops();
			for(Stop stop : stops) {
				sMapper.deleteStop(stop);
			}
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			
			PreparedStatement stm = connection.prepareStatement("DELETE FROM routes WHERE id = ?");			
			stm.setInt(1, route.getId());
		
			stm.executeUpdate();	
		
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Route findRouteById(int id) {
		Route route = null;
		
		try {
			StopMapper stopMapper = new StopMapper();
			List<Stop> stops = stopMapper.findStopsByRouteId(id);
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/city_bus_schema", "root", "root");
			
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM routes WHERE id = ?");
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				route = new Route(
						rs.getInt("id"), rs.getString("name"),
						stops
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return route;
	}
	
}
