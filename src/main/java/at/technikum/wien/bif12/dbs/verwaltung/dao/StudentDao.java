package at.technikum.wien.bif12.dbs.verwaltung.dao;

import at.technikum.wien.bif12.dbs.verwaltung.entities.Student;

public interface StudentDao {
	
	public Student create(Student b);

	public Student read(long id);

	public Student update(Student b);

	public void delete(Student b);

}
