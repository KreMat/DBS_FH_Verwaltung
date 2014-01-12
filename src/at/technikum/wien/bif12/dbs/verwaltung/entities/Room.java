package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Room extends AbstractDatabaseObject {

	// TODO mappen -> hab keine Ahnung welche Felder wir hier brauchen....brauch
	// nur eine toString

	private String name;

	public Room(String name) {
		super();
		this.name = name;
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
