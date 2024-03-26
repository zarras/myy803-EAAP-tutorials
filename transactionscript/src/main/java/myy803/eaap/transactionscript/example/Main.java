package myy803.eaap.transactionscript.example;

import java.util.ArrayList;

import myy803.eaap.transactionscript.example.scripts.TransactionScripts;


public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "--- City Bus Application Start ---" );        
        TransactionScripts tScripts = new TransactionScripts();
        
        tScripts.saveRoute(1, "RouteA");
        tScripts.saveStop(1, "StopA", 100, 200, TransactionScripts.STOP_STATUS_OK, 1);
        tScripts.saveStop(2, "StopB", 200, 400, TransactionScripts.STOP_STATUS_OK, 1);
        tScripts.saveStop(3, "StopC", 600, 600, TransactionScripts.STOP_STATUS_OK, 1);

        System.out.println("Checking StopA Status");
        System.out.println(tScripts.reportStopStatus(1));
        
        System.out.println("Checking StopB Status");
        System.out.println(tScripts.reportStopStatus(2));
        
        System.out.println("Checking StopC Status");
        System.out.println(tScripts.reportStopStatus(3));
        
        System.out.println("Changing StopB Status");
        tScripts.changeStopStatus(1, 2);
        
        System.out.println("Checking Route A Status");
        System.out.println(tScripts.reportRouteStatus(1));

//        tScripts.deleteStop(1);
//        tScripts.deleteStop(2);
//        tScripts.deleteStop(3);
        tScripts.deleteRoute(1);

        System.out.println( "--- City Bus Application Done ---" );        

    }
}
