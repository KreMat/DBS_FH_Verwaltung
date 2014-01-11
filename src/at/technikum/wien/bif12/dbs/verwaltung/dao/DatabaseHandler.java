package at.technikum.wien.bif12.dbs.verwaltung.dao;

import java.util.List;

import at.technikum.wien.bif12.dbs.verwaltung.entities.Anwesenheitsliste;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Course;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lektor;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lesson;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Semester;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Student;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Studiengang;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Template;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Zeugnis;

public interface DatabaseHandler {

	public boolean addLektor(Lektor l);

	public boolean addStudent(Student s);

	public boolean addStudiengang(Studiengang s);

	public boolean addTemplate(Template t);

	public boolean addSemester(Semester s);

	public boolean assignCourseToSemester(Course c, long semesterId);

	public boolean addLesson(Lesson l);

	public boolean registerGrade(long studentId, long courseId, int grade);

	public Zeugnis ladeZeugnis(long studenId, String semesterToken);

	public List<Lesson> ladeStundenplan(long studentId, String dayStart,
			String dayEnd);

	public Anwesenheitsliste ladeAnwesenheitsliste(long courseId);

	public Course ladeFreifacher();

	public boolean assignStudentToCourse(long studentId, long courseId);

	public List<String> ladeStudiengaenge();

	public List<String> ladeGehaltsklassen();

}
