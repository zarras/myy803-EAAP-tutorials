package myy803.eaap.tablemodulegateway.example;

import myy803.eaap.tablemodulegateway.example.gateways.RouteGateway;
import myy803.eaap.tablemodulegateway.example.gateways.StopGateway;
import myy803.eaap.tablemodulegateway.example.modules.RouteModule;
import myy803.eaap.tablemodulegateway.example.modules.StopModule;


public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "--- City Bus Application Start ---" );        
       
        RouteGateway routeGateway = new RouteGateway();
        StopGateway stopGateway = new StopGateway();
        
        RouteModule routeModule = new RouteModule();
        StopModule stopModule = new StopModule();
        
        routeGateway.saveRoute(1, "RouteA");
        
        stopGateway.saveStop(1, "StopA", 100, 200, StopGateway.STOP_STATUS_OK, 1);
        stopGateway.saveStop(2, "StopB", 200, 400, StopGateway.STOP_STATUS_OK, 1);
        stopGateway.saveStop(3, "StopC", 600, 600, StopGateway.STOP_STATUS_OK, 1);

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

        routeGateway.deleteRoute(1);

        System.out.println( "--- City Bus Application Done ---" );        

    }
}
