package domainmodel.datamapper.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import domainmodel.datamapper.springboot.domainmodel.Route;
import domainmodel.datamapper.springboot.domainmodel.Stop;
import domainmodel.datamapper.springboot.mappers.RouteMapper;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private RouteMapper routeMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		routeMapper.deleteAll();
		
		System.out.println("Creating Routes");
				
		Route routeA = new Route(1, "RouteA");
		
		routeA.addStop(new Stop(1, "StopA", 0, 0, 0));
		routeA.addStop(new Stop(2, "StopB", 100, 50, 0));
		routeA.addStop(new Stop(3, "StopC", 78, 500, 0));
		
		Route routeB = new Route(2, "RouteB");
		
		routeB.addStop(new Stop(4, "StopD", 0, 0, 0));
		routeB.addStop(new Stop(5, "StopE", 100, 50, 0));
		routeB.addStop(new Stop(6, "StopF", 78, 500, 0));
		

		System.out.println("\n\nSaving Routes");
		routeMapper.save(routeA);
		routeMapper.save(routeB);

		System.out.println("\n\nFinding all Routes");

		List<Route> allRoutes = routeMapper.findAll();
		for(Route foundRoute : allRoutes) {
			System.out.println("Found route: " + foundRoute.reportStatus());
		}
		
		routeMapper.deleteAll();

		System.out.println("\n\nAll Done!!");

	}

}
