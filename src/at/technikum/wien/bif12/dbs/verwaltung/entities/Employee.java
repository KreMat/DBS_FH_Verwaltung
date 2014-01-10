package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Employee extends Person {

	private SalaryClass salaryClass;

	public SalaryClass getSalaryClass() {
		return salaryClass;
	}

	public void setSalaryClass(SalaryClass salaryClass) {
		this.salaryClass = salaryClass;
	}

}
