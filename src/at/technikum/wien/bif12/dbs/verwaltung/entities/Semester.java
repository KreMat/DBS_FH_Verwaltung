package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Semester {

	private String token;
	private String start_day;
	private String end_day;

	public Semester() {

	}

	public Semester(String token, String start_day, String end_day) {
		super();
		this.token = token;
		this.start_day = start_day;
		this.end_day = end_day;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStart_day() {
		return start_day;
	}

	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}

	public String getEnd_day() {
		return end_day;
	}

	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}

}
