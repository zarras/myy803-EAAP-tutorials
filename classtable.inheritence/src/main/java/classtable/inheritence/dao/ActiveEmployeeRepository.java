package classtable.inheritence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import classtable.inheritence.model.ActiveEmployee;


@Repository
public interface ActiveEmployeeRepository extends JpaRepository<ActiveEmployee, Integer> {
}
