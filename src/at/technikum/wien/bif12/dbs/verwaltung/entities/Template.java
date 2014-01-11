package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Template {

	private String studiengang;
	private String name;
	private String token;
	private long participants;
	private double ects;

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

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}

	public String getStudiengang() {
		return studiengang;
	}

}
