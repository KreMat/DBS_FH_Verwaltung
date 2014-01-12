package at.technikum.wien.bif12.dbs.verwaltung.dao.mock;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.bif12.dbs.verwaltung.dao.DatabaseHandler;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Anwesenheitsliste;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Course;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Grade;
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

public class DatabaseHandlerMock implements DatabaseHandler {

	@Override
	public boolean addLektor(Lektor l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStudent(Student s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStudiengang(Studiengang s) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addTemplate(Template t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addSemester(Semester s) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addCourse(Course c) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addLesson(Lesson l) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean registerGrade(long studentId, long courseId, int grade) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Zeugnis ladeZeugnis(long studenId, String semesterToken) {
		Zeugnis z = new Zeugnis();
		z.setFirstname("Matthias");
		z.setLastname("Kreuzriegler");
		z.setStudiengang("Bachelor Informatik");
		Grade g1 = new Grade();
		g1.setLehrveranstaltung("Datenbanken");
		g1.setEcts(3.5d);
		g1.setGrade(1);
		z.getGrades().add(g1);
		return z;
	}

	@Override
	public List<NamedLesson> ladeStundenplan(long studentId, String dayStart,
			String dayEnd) {
		List<NamedLesson> list = new ArrayList<NamedLesson>();
		list.add(new NamedLesson("Datenabanken", "A_1.04b", new Date(System
				.currentTimeMillis()), new Date(System.currentTimeMillis())));
		list.add(new NamedLesson("Datenabanken", "A_1.04b", new Date(System
				.currentTimeMillis()), new Date(System.currentTimeMillis())));
		list.add(new NamedLesson("Datenabanken", "A_1.04b", new Date(System
				.currentTimeMillis()), new Date(System.currentTimeMillis())));
		return list;
	}

	@Override
	public Anwesenheitsliste ladeAnwesenheitsliste(long courseId) {
		Anwesenheitsliste a = new Anwesenheitsliste();
		a.setLehrveranstaltung("Datenbanksysteme");
		List<String> list = new ArrayList<String>();
		list.add("Thomas Koller");
		list.add("Richard Winterhalder");
		list.add("Matthias Kreuzriegler");
		a.setNames(list);
		return a;
	}

	@Override
	public List<NamedCourse> ladeFreifacher(long semesterId) {
		List<NamedCourse> list = new ArrayList<NamedCourse>();
		list.add(new NamedCourse(1, "LV1"));
		list.add(new NamedCourse(2, "LV2"));
		list.add(new NamedCourse(3, "LV3"));
		list.add(new NamedCourse(4, "LV4"));
		return list;
	}

	@Override
	public boolean assignStudentToCourse(long studentId, long courseId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Studiengang> ladeStudiengaenge() {
		List<Studiengang> list = new ArrayList<Studiengang>();
		list.add(new Studiengang(1, "Informatik", 1, 100, "Bachelor"));
		list.add(new Studiengang(1, "Wirtschaftsinformatik", 1, 100, "Bachelor"));
		list.add(new Studiengang(1, "Software Engineering", 1, 100, "Master"));
		return list;
	}

	@Override
	public List<String> ladeGehaltsklassen() {
		List<String> list = new ArrayList<String>();
		list.add("A1");
		list.add("A2");
		return list;
	}

	@Override
	public List<Lektor> ladeAlleLektoren() {
		List<Lektor> list = new ArrayList<Lektor>();
		Lektor l1 = new Lektor();
		l1.setFirstname("Hans");
		l1.setLastname("Mueller");
		list.add(l1);
		Lektor l2 = new Lektor();
		l2.setFirstname("Hans2");
		l2.setLastname("Mueller2");
		list.add(l2);
		return list;
	}

	@Override
	public List<Semester> ladeAlleSemester() {
		List<Semester> list = new ArrayList<Semester>();
		list.add(new Semester("WS 2012/2013", null, null));
		list.add(new Semester("SS 2013", null, null));
		list.add(new Semester("WS 2013/2014", null, null));
		return list;
	}

	@Override
	public List<Template> ladeAlleTemplate() {
		List<Template> list = new ArrayList<Template>();
		return list;
	}

	@Override
	public List<GradedStudent> ladeStudenten(long courseId) {
		List<GradedStudent> list = new ArrayList<GradedStudent>();
		list.add(new GradedStudent("Thomas" + courseId, "Koller", 1));
		list.add(new GradedStudent("Richard" + courseId, "Winterhalder", 1));
		list.add(new GradedStudent("Matthias" + courseId, "Kreuzriegler", 1));
		return list;
	}

	@Override
	public List<NamedCourse> ladeAlleLvs() {
		List<NamedCourse> list = new ArrayList<NamedCourse>();
		list.add(new NamedCourse(1, "LV1"));
		list.add(new NamedCourse(2, "LV2"));
		list.add(new NamedCourse(3, "LV3"));
		list.add(new NamedCourse(4, "LV4"));
		return list;
	}

	@Override
	public List<Room> ladeAlleRaeume() {
		List<Room> list = new ArrayList<Room>();
		list.add(new Room("Room1"));
		list.add(new Room("Room2"));
		list.add(new Room("Room3"));
		list.add(new Room("Room4"));
		list.add(new Room("Room5"));
		return list;
	}

	@Override
	public List<Student> ladeAlleStudenten() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Thomas", "Koller", 1));
		list.add(new Student("Richard", "Winterhalder", 2));
		list.add(new Student("Matthias", "Kreuzriegler", 3));
		return list;
	}

	@Override
	public List<NamedCourse> ladeLvs(long semesterId) {
		List<NamedCourse> list = new ArrayList<NamedCourse>();
		list.add(new NamedCourse(1, "LV1"));
		list.add(new NamedCourse(2, "LV2"));
		list.add(new NamedCourse(3, "LV3"));
		list.add(new NamedCourse(4, "LV4"));
		return list;
	}

}
