package at.technikum.wien.bif12.dbs.verwaltung.test;

import at.technikum.wien.bif12.dbs.verwaltung.dao.impl.DatabaseHandlerImpl;
import at.technikum.wien.bif12.dbs.verwaltung.dao.mock.DatabaseHandlerMock;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lektor;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Student;

public class Main {

	public static void main(String[] args) {
		DatabaseHandlerImpl dhm = new DatabaseHandlerImpl();
		dhm.init();
		
		
		//dhm.addLektor(new Lektor("penis","klaus","abs","1200","123412341","penx@asdfa.com","penx",1));
		//dhm.addStudent(new Student("penis","klaus","abs","1200","123412341","penx@asdfa.com","Informatik",1210234089,"heinz"));
		
		
		

	}

}
