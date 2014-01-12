package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Room extends AbstractDatabaseObject {

	// TODO mappen -> hab keine Ahnung welche Felder wir hier brauchen....brauch
	// nur eine toString

	private long buildingId;
	private String name;
	private String token;
	private String floor;

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

	public long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(long buildingId) {
		this.buildingId = buildingId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

}
