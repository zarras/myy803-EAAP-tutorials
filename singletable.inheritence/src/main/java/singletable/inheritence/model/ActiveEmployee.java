package singletable.inheritence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class ActiveEmployee extends Employee {
	@Column(name = "salary")
	private double salary;
	
	public ActiveEmployee() {
		super();
	}

	public ActiveEmployee(int eid, String name, double salary) {
		super(eid, name);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return super.toString() + "ActiveEmployee [salary=" + salary + "]";
	}
	
}
