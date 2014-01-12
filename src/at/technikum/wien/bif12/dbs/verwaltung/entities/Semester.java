package at.technikum.wien.bif12.dbs.verwaltung.entities;

import java.util.Date;

public class Semester extends AbstractDatabaseObject {

	private String token;
	private Date startDay;
	private Date endDay;

	public Semester() {

	}

	public Semester(String token, Date startDay, Date endDay) {
		super();
		this.token = token;
		this.startDay = startDay;
		this.endDay = endDay;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	@Override
	public String toString() {
		return token;
	}
}
