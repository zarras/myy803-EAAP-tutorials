package foreignkey.mapping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foreignkey.mapping.model.Route;
import foreignkey.mapping.model.Stop;

@Repository
public interface StopDAORepository extends JpaRepository<Stop, Integer> {
	Stop findById(int id);
}