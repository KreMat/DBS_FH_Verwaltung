package at.technikum.wien.bif12.dbs.verwaltung.entities;

public abstract class AbstractDBObject {

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
