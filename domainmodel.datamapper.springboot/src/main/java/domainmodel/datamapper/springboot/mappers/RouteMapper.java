package domainmodel.datamapper.springboot.mappers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domainmodel.datamapper.springboot.domainmodel.Route;


@Repository
public interface RouteMapper extends JpaRepository<Route, Integer> {
	Route findById(int id);
	List<Route> findByName(String name);
}
