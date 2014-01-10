package at.technikum.wien.bif12.dbs.verwaltung.entities;

import java.util.List;

public class Student extends Person {

	private CourseOfStudies courseOfStudies;

	private List<Course> courses;

	public CourseOfStudies getCourseOfStudies() {
		return courseOfStudies;
	}

	public void setCourseOfStudies(CourseOfStudies courseOfStudies) {
		this.courseOfStudies = courseOfStudies;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
