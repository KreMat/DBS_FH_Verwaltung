package at.technikum.wien.bif12.dbs.verwaltung.dao;

import at.technikum.wien.bif12.dbs.verwaltung.entities.SalaryClass;

public interface SalaryClassDao {
	
	public SalaryClass create(SalaryClass b);

	public SalaryClass read(long id);

	public SalaryClass update(SalaryClass b);

	public void delete(SalaryClass b);

}
