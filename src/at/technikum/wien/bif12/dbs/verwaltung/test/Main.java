package at.technikum.wien.bif12.dbs.verwaltung.test;

import java.util.List;

import at.technikum.wien.bif12.dbs.verwaltung.dao.impl.DatabaseHandlerImpl;
import at.technikum.wien.bif12.dbs.verwaltung.dao.mock.DatabaseHandlerMock;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Anwesenheitsliste;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Course;
import at.technikum.wien.bif12.dbs.verwaltung.entities.GradedStudent;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lektor;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lesson;
import at.technikum.wien.bif12.dbs.verwaltung.entities.NamedCourse;
import at.technikum.wien.bif12.dbs.verwaltung.entities.NamedLesson;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Room;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Semester;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Student;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Studiengang;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Template;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Zeugnis;

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
	
		
		if(dhm.registerGrade(3, 1, 1)) {
			System.out.println("erfolgreich");
		}
		
		
		Zeugnis z = dhm.ladeZeugnis(3, "WS2013");
		System.out.println(z.getFirstname() + " " + z.getLastname() + " " + z.getStudiengang()+ " " + z.getGrades().get(0).getEcts() + " " + z.getGrades().get(0).getLehrveranstaltung() + " " + z.getGrades().get(0).getGrade());
		
		
		List<NamedLesson> l = dhm.ladeStundenplan(1, "2012-10-1", "2014-10-1");
		System.out.println(l.toString());
		
		
		Anwesenheitsliste a = dhm.ladeAnwesenheitsliste(1);
		String erg = "";
	    for(int i=0;i<a.getNames().size();i++) {
	    	erg += a.getNames().get(i) + "\n";
	    }
	    System.out.println(a.getLehrveranstaltung() + " " + erg);
	    
	    
		*/
		List<NamedCourse> l = dhm.ladeFreifacher(1);
		System.out.println(l.toString());
		
		/*
		if(dhm.assignStudentToCourse(1, 9)) {
			System.out.println("Erfolgreich");
		}
		
		List<Studiengang> l = dhm.ladeStudiengaenge();
		System.out.println(l.toString());
		
		
		List<String> l = dhm.ladeGehaltsklassen();
		System.out.println(l.toString());
		
		List<Lektor> l = dhm.ladeAlleLektoren();
		System.out.println(l.toString());
		
		
		List<Semester> l = dhm.ladeAlleSemester();
		System.out.println(l.toString());
		
		List<Template> l = dhm.ladeAlleTemplate();
		System.out.println(l.toString());
		
		List<GradedStudent> l = dhm.ladeStudenten(1);
		
		
	    System.out.println(erg);
	    
		
		List<NamedCourse> l = dhm.ladeAlleLvs();
		String erg = "";
	    for(int i=0;i<l.size();i++) {
	    	erg += l.get(i).getName() + " " + l.get(i).getCourseOfStudiesId() + " " + l.get(i).getCourseTemplateId() + " " + l.get(i).getSemesterId() + " " + l.get(i).getLektorId()+ "\n";
	    }
		System.out.println(erg);
		
		
		List<Room> l = dhm.ladeAlleRaeume();
		String erg = "";
	    for(int i=0;i<l.size();i++) {
	    	erg += l.get(i).getId() + " " + l.get(i).getName() + "\n";
	    }
	    System.out.println(erg);
	    
		
		List<Student> l = dhm.ladeAlleStudenten();
		System.out.println(l.toString());
		*/
		
		
	}

}
