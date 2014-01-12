package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Course extends AbstractDatabaseObject {
	private long courseOfStudiesId;
	private long courseTemplateId;
	private long semesterId;
	private long lektorId;

	public long getCourseOfStudiesId() {
		return courseOfStudiesId;
	}

	public void setCourseOfStudiesId(long courseOfStudiesId) {
		this.courseOfStudiesId = courseOfStudiesId;
	}

	public long getCourseTemplateId() {
		return courseTemplateId;
	}

	public void setCourseTemplateId(long courseTemplateId) {
		this.courseTemplateId = courseTemplateId;
	}

	public long getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(long semesterId) {
		this.semesterId = semesterId;
	}

	public long getLektorId() {
		return lektorId;
	}

	public void setLektorId(long lektorId) {
		this.lektorId = lektorId;
	}

}
