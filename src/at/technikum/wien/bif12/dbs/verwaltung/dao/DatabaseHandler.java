package at.technikum.wien.bif12.dbs.verwaltung.dao;

import java.util.List;

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
import at.technikum.wien.bif12.dbs.verwaltung.exceptions.GUIsqlException;

public interface DatabaseHandler {

	public boolean addLektor(Lektor l);

	public boolean addStudent(Student s) throws GUIsqlException;

	public boolean addStudiengang(Studiengang s);

	public boolean addTemplate(Template t);

	public boolean addSemester(Semester s);

	public boolean addCourse(Course c);

	public boolean addLesson(Lesson l);

	public boolean registerGrade(long studentId, long courseId, int grade);

	public Zeugnis ladeZeugnis(long studentId, String semesterToken);

	public List<NamedLesson> ladeStundenplan(long studentId, String dayStart,
			String dayEnd);

	public Anwesenheitsliste ladeAnwesenheitsliste(long courseId);

	public List<NamedCourse> ladeFreifacher(long semesterId);

	public boolean assignStudentToCourse(long studentId, long courseId);

	public List<Studiengang> ladeStudiengaenge();

	public List<String> ladeGehaltsklassen();

	public List<Lektor> ladeAlleLektoren();

	public List<Semester> ladeAlleSemester();

	public List<Template> ladeAlleTemplate();

	public List<GradedStudent> ladeStudenten(long courseId);

	public List<NamedCourse> ladeAlleLvs();

	public List<Room> ladeAlleRaeume();

	public List<Student> ladeAlleStudenten();

	public List<NamedCourse> ladeLvs(long semesterId);

}
