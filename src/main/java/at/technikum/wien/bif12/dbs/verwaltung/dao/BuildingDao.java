package at.technikum.wien.bif12.dbs.verwaltung.dao;

import at.technikum.wien.bif12.dbs.verwaltung.entities.Building;

public interface BuildingDao {
	
	public Building create(Building b);

	public Building read(long id);

	public Building update(Building b);

	public void delete(Building b);

}
