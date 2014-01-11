package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Template {

	private long courseOfStudiesId;
	private String name;
	private String token;
	private long participants;
	private double ects;
	private double sppw;

	public long getCourseOfStudiesId() {
		return courseOfStudiesId;
	}

	public void setCourseOfStudiesId(long courseOfStudiesId) {
		this.courseOfStudiesId = courseOfStudiesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getParticipants() {
		return participants;
	}

	public void setParticipants(long participants) {
		this.participants = participants;
	}

	public double getEcts() {
		return ects;
	}

	public void setEcts(double ects) {
		this.ects = ects;
	}

	public double getSppw() {
		return sppw;
	}

	public void setSppw(double sppw) {
		this.sppw = sppw;
	}

}
