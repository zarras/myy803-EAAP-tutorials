package mvc.controller.template.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.controller.template.dao.EmployeeMapper;
import mvc.controller.template.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeMapper theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Employee result = employeeRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
}






