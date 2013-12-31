package at.technikum.wien.bif12.dbs.verwaltung.dao;

import at.technikum.wien.bif12.dbs.verwaltung.entities.Material;

public interface MaterialDao {
	
	public Material create(Material b);

	public Material read(long id);

	public Material update(Material b);

	public void delete(Material b);

}
