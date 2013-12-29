package at.technikum.wien.bif12.dbs.verwaltung.entities;

import java.util.List;

public class Course {

	private CourseTemplate template;

	private List<Student> students;

	private List<Lecturer> lecturers;

	private List<Lesson> lessons;

	public CourseTemplate getTemplate() {
		return template;
	}

	public void setTemplate(CourseTemplate template) {
		this.template = template;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

}
