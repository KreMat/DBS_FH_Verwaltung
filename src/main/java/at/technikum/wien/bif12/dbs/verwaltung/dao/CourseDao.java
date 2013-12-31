package at.technikum.wien.bif12.dbs.verwaltung.dao;

import at.technikum.wien.bif12.dbs.verwaltung.entities.Course;

public interface CourseDao {

	public Course create(Course b);

	public Course read(long id);

	public Course update(Course b);

	public void delete(Course b);

}
