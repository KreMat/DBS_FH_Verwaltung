package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class NamedCourse extends Course {

	private String name;

	public NamedCourse(int id, String name) {
		super();
		this.name = name;
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
