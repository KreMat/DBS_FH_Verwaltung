package at.technikum.wien.bif12.dbs.verwaltung.entities;

import java.util.ArrayList;
import java.util.List;

public class Zeugnis {

	private String firstname;

	private String lastname;

	private String studiengang;

	private List<Grade> grades = new ArrayList<Grade>();

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

}
