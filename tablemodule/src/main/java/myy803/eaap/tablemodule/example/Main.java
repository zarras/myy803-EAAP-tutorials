package myy803.eaap.tablemodule.example;

import myy803.eaap.tablemodule.example.modules.RouteModule;
import myy803.eaap.tablemodule.example.modules.StopModule;


public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "--- City Bus Application Start ---" );        
        RouteModule routeModule = new RouteModule();
        StopModule stopModule = new StopModule();
        
        routeModule.saveRoute(1, "RouteA");
        
        stopModule.saveStop(1, "StopA", 100, 200, StopModule.STOP_STATUS_OK, 1);
        stopModule.saveStop(2, "StopB", 200, 400, StopModule.STOP_STATUS_OK, 1);
        stopModule.saveStop(3, "StopC", 600, 600, StopModule.STOP_STATUS_OK, 1);

        System.out.println("Checking StopA Status");
        System.out.println(stopModule.reportStopStatus(1));
        
        System.out.println("Checking StopB Status");
        System.out.println(stopModule.reportStopStatus(2));
        
        System.out.println("Checking StopC Status");
        System.out.println(stopModule.reportStopStatus(3));
        
        System.out.println("Changing StopB Status");
        stopModule.setStopStatus(1, 2);
        
        System.out.println("Checking Route A Status");
        System.out.println(routeModule.reportRouteStatus(1));

        routeModule.deleteRoute(1);

        System.out.println( "--- City Bus Application Done ---" );        

    }
}
