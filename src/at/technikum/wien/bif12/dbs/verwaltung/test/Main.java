package at.technikum.wien.bif12.dbs.verwaltung.test;

import at.technikum.wien.bif12.dbs.verwaltung.dao.impl.DatabaseHandlerImpl;
import at.technikum.wien.bif12.dbs.verwaltung.dao.mock.DatabaseHandlerMock;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Course;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lektor;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lesson;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Semester;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Student;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Studiengang;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Template;

public class Main {

	public static void main(String[] args) {
		DatabaseHandlerImpl dhm = new DatabaseHandlerImpl();
		dhm.init("jdbc:oracle:thin:@localhost:1521:XE", "FH_Verwaltung_db", "123456");
		/*
		Lektor l = new Lektor();
		l.setFirstname("klaus");
		l.setLastname("Kleber");
		l.setAdress("Zirbenweg 5");
		l.setZip("1200");
		l.setTelefon("1231314321");
		l.setEmail("klaus@gmx.com");
		l.setToken("klkl");
		l.setGehaltsklasse("A2");
		
		dhm.addLektor(l);
		System.out.println("Lektor added!");
		
		Student s = new Student();
		s.setFirstname("Hans");
		s.setLastname("Fridolin");
		s.setAdress("Zirbenweg 6");
		s.setZip("1200");
		s.setTelefon("1231314321");
		s.setEmail("Hans@gmx.com");
		s.setToken("hafr");
		s.setStudiengangName("Informatik");
		s.setStudentnr(123312312);
		
		if(dhm.addStudent(s)) {
			System.out.println("Student added!");
		};
		
		
		Studiengang s = new Studiengang();
		s.setLecturer_id(1);
		s.setName("Peniskunde");
		s.setNr(120);
		s.setParticipants(60);
		s.setDegree("Master");
		if(dhm.addStudiengang(s)) {
			System.out.println("erfolgrich");
		}
		
		Template t = new Template();
		t.setCourseOfStudiesId(5);
		t.setSemester(1);
		t.setName("messen");
		t.setToken("MES");
		t.setParticipants(50);
		t.setEcts(4.5d);
		t.setSws(3);
		if(dhm.addTemplate(t)) {
			System.out.println("erfolgreich");
		}
		
		
		Semester s = new Semester();
		s.setToken("WS2020");
		s.setStart_day("2020-09-14");
		s.setEnd_day("2021-01-16");
		if(dhm.addSemester(s)) {
			System.out.println("erfolgreich");
		}
		
		
		Course c = new Course();
		c.setCourseOfStudiesId(5);
		c.setCourseTemplateId(9);
		c.setSemesterId(1);
		c.setLektorId(1);
		if(dhm.addCourse(c)) {
			System.out.println("erfolgreich");
		}
		
		
		Lesson l = new Lesson();
		l.setCourse_id(9);
		l.setRoom_id(1);
		l.setStart_time("2014-10-01 12:10:00");
		l.setEnd_time("2014-10-01 14:30:00");
		
		if(dhm.addLesson(l)) {
			System.out.println("erfolgreich");
		}
	*/
	}

}
