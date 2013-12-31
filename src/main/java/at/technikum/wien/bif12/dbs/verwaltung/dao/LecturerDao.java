package at.technikum.wien.bif12.dbs.verwaltung.dao;

import at.technikum.wien.bif12.dbs.verwaltung.entities.Lecturer;

public interface LecturerDao {
	
	public Lecturer create(Lecturer b);

	public Lecturer read(long id);

	public Lecturer update(Lecturer b);

	public void delete(Lecturer b);

}
