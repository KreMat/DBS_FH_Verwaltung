package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Grade {

	private String lehrveranstaltung;

	private double ects;

	private int grade;

	public String getLehrveranstaltung() {
		return lehrveranstaltung;
	}

	public void setLehrveranstaltung(String lehrveranstaltung) {
		this.lehrveranstaltung = lehrveranstaltung;
	}

	public double getEcts() {
		return ects;
	}

	public void setEcts(double ects) {
		this.ects = ects;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
