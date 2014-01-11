package at.technikum.wien.bif12.dbs.verwaltung.dao.mock;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.bif12.dbs.verwaltung.dao.DatabaseHandler;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Anwesenheitsliste;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Course;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lektor;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lesson;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> ladeStundenplan(long studentId, String dayStart,
			String dayEnd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Anwesenheitsliste ladeAnwesenheitsliste(long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course ladeFreifacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean assignStudentToCourse(long studentId, long courseId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> ladeStudiengaenge() {
		List<String> list = new ArrayList<String>();
		list.add("Bachelor Informatik");
		list.add("Bachelor Wirtschaftsinformatik");
		list.add("Master Wirtschaftsinformatik");
		list.add("Master Software Engineering");
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

}
