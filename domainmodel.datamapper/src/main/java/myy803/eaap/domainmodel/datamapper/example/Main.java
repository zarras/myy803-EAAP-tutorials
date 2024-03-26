package myy803.eaap.domainmodel.datamapper.example;

import java.util.ArrayList;

import myy803.eaap.domainmodel.datamapper.example.domainmodel.Route;
import myy803.eaap.domainmodel.datamapper.example.domainmodel.Stop;
import myy803.eaap.domainmodel.datamapper.example.mappers.RouteMapper;


public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "--- City Bus Application Start ---" );        
       
        RouteMapper routeMapper= new RouteMapper();
          
        Route route = new Route(1, "RouteA", new ArrayList<Stop>());
        
        Stop stopA = new Stop(1, "StopA", 100, 200, Stop.STOP_STATUS_OK, 1);
        Stop stopB = new Stop(2, "StopB", 200, 400, Stop.STOP_STATUS_OK, 1);
        Stop stopC = new Stop(3, "StopC", 600, 600, Stop.STOP_STATUS_OK, 1);

        route.addStop(stopA);
        route.addStop(stopB);
        route.addStop(stopC);
        
        System.out.println("Saving Route");

        routeMapper.saveRoute(route);
        
        System.out.println("Retrieving Stored Route");
        
        Route storedRoute = routeMapper.findRouteById(1);

        System.out.println("Checking Route Status");

        System.out.println(storedRoute.reportStatus());

        routeMapper.deleteRoute(storedRoute);

        System.out.println( "--- City Bus Application Done ---" );        

    }
}
