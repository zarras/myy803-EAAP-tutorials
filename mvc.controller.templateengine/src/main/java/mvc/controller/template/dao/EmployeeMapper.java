package mvc.controller.template.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mvc.controller.template.entity.Employee;

@Repository
public interface EmployeeMapper extends JpaRepository<Employee, Integer> {
	
	public Employee findById(int theId);
		
}
