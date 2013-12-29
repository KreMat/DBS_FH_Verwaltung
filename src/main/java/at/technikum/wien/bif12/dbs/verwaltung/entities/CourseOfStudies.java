package at.technikum.wien.bif12.dbs.verwaltung.entities;

import java.util.List;

public class CourseOfStudies {

	private Lecturer chief;

	public Lecturer getChief() {
		return chief;
	}

	public void setChief(Lecturer chief) {
		this.chief = chief;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	private List<Course> courses;

}
