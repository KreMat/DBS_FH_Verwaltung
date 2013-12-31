package at.technikum.wien.bif12.dbs.verwaltung.dao;

import at.technikum.wien.bif12.dbs.verwaltung.entities.Employee;

public interface EmployeeDao {

	public Employee create(Employee b);

	public Employee read(long id);

	public Employee update(Employee b);

	public void delete(Employee b);

}
