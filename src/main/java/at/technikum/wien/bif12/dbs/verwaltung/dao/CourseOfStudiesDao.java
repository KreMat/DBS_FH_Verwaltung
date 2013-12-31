package at.technikum.wien.bif12.dbs.verwaltung.dao;

import at.technikum.wien.bif12.dbs.verwaltung.entities.CourseOfStudies;

public interface CourseOfStudiesDao {
	
	public CourseOfStudies create(CourseOfStudies b);

	public CourseOfStudies read(long id);

	public CourseOfStudies update(CourseOfStudies b);

	public void delete(CourseOfStudies b);

}
