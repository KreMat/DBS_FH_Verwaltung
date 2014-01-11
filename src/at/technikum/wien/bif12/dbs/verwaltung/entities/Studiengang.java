package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Studiengang {

	private long lecturer_id;
	private String name;
	private long nr;
	private long participants;
	private String degree;

	public Studiengang() {

	}

	public Studiengang(long lecturer_id, String name, long nr,
			long participants, String degree) {
		super();
		this.lecturer_id = lecturer_id;
		this.name = name;
		this.nr = nr;
		this.participants = participants;
		this.degree = degree;
	}

	public long getLecturer_id() {
		return lecturer_id;
	}

	public void setLecturer_id(long lecturer_id) {
		this.lecturer_id = lecturer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNr() {
		return nr;
	}

	public void setNr(long nr) {
		this.nr = nr;
	}

	public long getParticipants() {
		return participants;
	}

	public void setParticipants(long participants) {
		this.participants = participants;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

}
