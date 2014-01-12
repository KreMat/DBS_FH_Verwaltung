package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class GradedStudent extends Student {

	private Integer grade;

	public GradedStudent() {
		super();
	}

	public GradedStudent(String firstname, String lastname, Integer grade) {
		super();
		setFirstname(firstname);
		setLastname(lastname);
		this.grade = grade;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}
