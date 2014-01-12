package at.technikum.wien.bif12.dbs.verwaltung.factory;

import at.technikum.wien.bif12.dbs.verwaltung.dao.DatabaseHandler;
import at.technikum.wien.bif12.dbs.verwaltung.dao.impl.DatabaseHandlerImpl;

public class DatabaseHandlerFactory {

	public static DatabaseHandler createDatabaseHandler() {
		DatabaseHandlerImpl handler = new DatabaseHandlerImpl();
		handler.init("jdbc:oracle:thin:@localhost:1521:xe", "fhverwaltung",
				"123456");
		return handler;
	}

}
