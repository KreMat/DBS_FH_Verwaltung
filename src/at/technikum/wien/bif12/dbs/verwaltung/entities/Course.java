package at.technikum.wien.bif12.dbs.verwaltung.entities;

import java.util.List;

public class Course {
	private long courseOfStudiesId;
	private long courseTemplateId;
	private long semesterId;
	private List<Long> lekorIds;

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

	public List<Long> getLekorIds() {
		return lekorIds;
	}

	public void setLekorIds(List<Long> lekorIds) {
		this.lekorIds = lekorIds;
	}
	
	

}
