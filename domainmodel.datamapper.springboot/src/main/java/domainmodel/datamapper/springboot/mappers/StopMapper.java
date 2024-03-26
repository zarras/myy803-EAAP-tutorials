package domainmodel.datamapper.springboot.mappers;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domainmodel.datamapper.springboot.domainmodel.Stop;

@Repository
public interface StopMapper extends JpaRepository<Stop, Integer> {
	Stop findById(int id);
}
