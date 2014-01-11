package at.technikum.wien.bif12.dbs.verwaltung.factory;

import at.technikum.wien.bif12.dbs.verwaltung.dao.DatabaseHandler;
import at.technikum.wien.bif12.dbs.verwaltung.dao.mock.DatabaseHandlerMock;

public class DatabaseHandlerFactory {

	public static DatabaseHandler createDatabaseHandler() {
		return new DatabaseHandlerMock();
	}

}
