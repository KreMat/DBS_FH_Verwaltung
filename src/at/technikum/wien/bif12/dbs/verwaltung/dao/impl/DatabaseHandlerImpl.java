package at.technikum.wien.bif12.dbs.verwaltung.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class DatabaseHandlerImpl implements DatabaseHandler {
	private Connection con = null;

	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager
					.getConnection("jdbc:oracle:thin:thomas/thomas@localhost:1521:XE");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean addLektor(Lektor l) {
		String CREATE_LEKTOR = "{call usp_create_lecturer(?,?,?,?,?,?,?,?,?)}";
		try {
			CallableStatement cs = con.prepareCall(CREATE_LEKTOR);

			cs.setString(1, l.getFirstname());
			cs.setString(2, l.getLastname());
			cs.setString(3, l.getAdress());
			cs.setString(4, l.getZip());
			cs.setString(5, l.getTelefon());
			cs.setString(6, l.getEmail());
			cs.setString(7, l.getToken());
			cs.setString(8, l.getGehaltsklasse());

			cs.registerOutParameter(9, java.sql.Types.INTEGER);

			cs.executeUpdate();
			int erg = cs.getInt(9);

			if (erg == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to create Lector!");
			return false;
		}
	}

	@Override
	public boolean addStudent(Student s) {
		String CREATE_STUDENT = "{call usp_create_student(?,?,?,?,?,?,?,?,?,?)}";
		try {
			CallableStatement cs = con.prepareCall(CREATE_STUDENT);

			cs.setString(1, s.getFirstname());
			cs.setString(2, s.getLastname());
			cs.setString(3, s.getAdress());
			cs.setString(4, s.getZip());
			cs.setString(5, s.getTelefon());
			cs.setString(6, s.getEmail());

			// TODO THOMAS -> FIXME
			cs.setLong(7, s.getStudiengangId());
			// cs.setString(7, s.getCourse_of_studies_name());
			cs.setLong(8, s.getStudentnr());
			cs.setString(9, s.getToken());

			cs.registerOutParameter(10, java.sql.Types.INTEGER);

			cs.executeUpdate();

			int erg = cs.getInt(10);

			if (erg == 0)
				return true;
			else if (erg == -1)
				return false;
			else {
				System.out
						.println("Sorry there are to many students for that course!");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to create student!");
			return false;
		}
	}

	@Override
	public boolean addStudiengang(Studiengang s) {
		String CREATE_STUDIENGANG = "{call usp_create_course_of_studies(?,?,?,?,?,?)}";
		try {
			CallableStatement cs = con.prepareCall(CREATE_STUDIENGANG);

			cs.setLong(1, s.getLecturer_id());
			cs.setString(2, s.getName());
			cs.setLong(3, s.getNr());
			cs.setLong(4, s.getParticipants());
			cs.setString(5, s.getDegree());

			cs.registerOutParameter(6, java.sql.Types.INTEGER);

			cs.executeUpdate();

			int erg = cs.getInt(6);

			if (erg == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to create course of studies!");
			return false;
		}
	}

	@Override
	public boolean addTemplate(Template t) {
		String CREATE_TEMPLATE = "{call usp_create_course_template(?,?,?,?,?,?,?,?)}";
		try {
			CallableStatement cs = con.prepareCall(CREATE_TEMPLATE);

			cs.setLong(1, t.getCourseOfStudiesId());
			cs.setLong(2, t.getSemester());
			cs.setString(3, t.getName());
			cs.setString(4, t.getToken());
			cs.setLong(5, t.getParticipants());
			cs.setDouble(6, t.getEcts());
			cs.setDouble(7, t.getSws());

			cs.registerOutParameter(8, java.sql.Types.INTEGER);

			cs.executeUpdate();

			int erg = cs.getInt(8);

			if (erg == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to create template!");
			return false;
		}
	}

	@Override
	public boolean addSemester(Semester s) {
		String CREATE_SEMESTER = "{call usp_create_semester(?,?,?,?)}";
		try {
			CallableStatement cs = con.prepareCall(CREATE_SEMESTER);

			cs.setString(1, s.getToken());
			cs.setString(2, s.getStart_day());
			cs.setString(3, s.getEnd_day());

			cs.registerOutParameter(4, java.sql.Types.INTEGER);

			cs.executeUpdate();

			int erg = cs.getInt(4);

			if (erg == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to create semester!");
			return false;
		}
	}

	@Override
	public boolean addCourse(Course c) {
		String CREATE_COURSE = "{call usp_create_course(?,?,?,?,?)}";

		try {
			CallableStatement cs = con.prepareCall(CREATE_COURSE);

			cs.setLong(1, c.getCourseOfStudiesId());
			cs.setLong(2, c.getCourseTemplateId());
			cs.setLong(3, c.getSemesterId());
			cs.setLong(4, c.getLektorId());

			cs.registerOutParameter(5, java.sql.Types.INTEGER);

			cs.executeUpdate();

			int erg = cs.getInt(5);

			if (erg == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to create course!");
		}
		// String ASSIGN_COURSE_TO_SEMESTER =
		// "{call usp_assign_semester(?,?,?)}";
		// try {
		// CallableStatement cs = con.prepareCall(ASSIGN_COURSE_TO_SEMESTER);
		//
		// cs.setLong(1, c.getCourseOfStudiesId());
		// cs.setLong(2, semesterId);
		//
		// cs.registerOutParameter(3, java.sql.Types.INTEGER);
		//
		// cs.executeUpdate();
		//
		// int erg = cs.getInt(3);
		//
		// if (erg == 0)
		// return true;
		// else
		// return false;
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// System.out.println("Failed to assign course to semester!");
		// return false;
		// }
		return true;
	}

	@Override
	public boolean addLesson(Lesson l) {
		String CREATE_LESSON = "{call usp_create_lesson(?,?,?,?,?)}";
		try {
			CallableStatement cs = con.prepareCall(CREATE_LESSON);

			cs.setLong(1, l.getCourse_id());
			cs.setLong(2, l.getRoom_id());
			cs.setString(3, l.getStart_time());
			cs.setString(4, l.getEnd_time());

			cs.registerOutParameter(5, java.sql.Types.INTEGER);

			cs.executeUpdate();

			int erg = cs.getInt(5);

			if (erg == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to create lesson!");
			return false;
		}
	}

	@Override
	public boolean registerGrade(long studentId, long courseId, int grade) {
		String REGISTER_GRADE = "{call usp_register_grade(?,?,?,?)}";
		try {
			CallableStatement cs = con.prepareCall(REGISTER_GRADE);

			cs.setLong(1, studentId);
			cs.setLong(2, courseId);
			cs.setInt(3, grade);

			cs.registerOutParameter(4, java.sql.Types.INTEGER);

			cs.executeUpdate();

			int erg = cs.getInt(4);

			if (erg == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to register grade!");
			return false;
		}
	}

	@Override
	public Zeugnis ladeZeugnis(long studenId, String semesterToken) {
		String LADE_ZEUGNIS = "SELECT * FROM uv_create_certificate WHERE student_id = ? AND semester_token = ?;";
		Zeugnis z = new Zeugnis();
		List<Grade> grades = new ArrayList<Grade>();
		try {
			PreparedStatement ladeZeugnis = con.prepareStatement(LADE_ZEUGNIS);

			ladeZeugnis.setLong(1, studenId);
			ladeZeugnis.setString(2, semesterToken);

			ResultSet rs = ladeZeugnis.executeQuery();

			while (rs.next()) {
				z.setFirstname(rs.getString("firstname"));
				z.setLastname(rs.getString("lastname"));
				z.setStudiengang(rs.getString("course_of_studies"));

				Grade g = new Grade();
				g.setLehrveranstaltung(rs.getString("course_name"));
				g.setGrade(rs.getInt("grade"));
				g.setEcts(rs.getDouble("ects"));

				grades.add(g);
			}

			z.setGrades(grades);
			return z;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Couldnt create certificate!");
			return null;
		}
	}

	@Override
	public List<NamedLesson> ladeStundenplan(long studentId, String dayStart,
			String dayEnd) {
		String LADE_STUNDENPLAN = "SELECT * FROM uv_create_schedule WHERE (start_time"
				+ " >= TO_TIMESTAMP(?, 'YYYY-MM-DD') AND end_time"
				+ " <= TO_TIMESTAMP(?, 'YYYY-MM-DD')) AND (student_id = ?);";
		List<NamedLesson> nl = new ArrayList<NamedLesson>();

		try {
			PreparedStatement getStundenplan = con
					.prepareStatement(LADE_STUNDENPLAN);
			getStundenplan.setString(1, dayStart);
			getStundenplan.setString(2, dayEnd);
			getStundenplan.setLong(3, studentId);

			ResultSet rs = getStundenplan.executeQuery();

			while (rs.next()) {
				NamedLesson nal = new NamedLesson(rs.getString("course_name"),
						rs.getString("room"), rs.getDate("start_time")
								.toString(), rs.getDate("end_time").toString());
				nl.add(nal);
			}

			return nl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not load timetable");
			return null;
		}
	}

	@Override
	public Anwesenheitsliste ladeAnwesenheitsliste(long courseId) {
		String LOAD_REGISTERLIST = "SELECT * FROM uv_create_register_list WHERE course_id = ?;";
		String GET_COURSE_NAME = "SELECT id, name FROM tb_course_template WHERE id = ?;";
		Anwesenheitsliste awhl = new Anwesenheitsliste();
		try {
			PreparedStatement getName = con.prepareStatement(GET_COURSE_NAME);
			getName.setLong(1, courseId);
			ResultSet name = getName.executeQuery();
			awhl.setLehrveranstaltung(name.getString("name"));

			PreparedStatement ps = con.prepareStatement(LOAD_REGISTERLIST);
			ps.setLong(1, courseId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long studentNr = rs.getLong("studentennr");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");

				String entry = studentNr + " " + firstname + " " + lastname;
				awhl.getNames().add(entry);
			}
			return awhl;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Couldnt make a registerlist");
			return null;
		}

	}

	@Override
	public List<NamedCourse> ladeFreifacher(long semesterId) {
		String LADE_FREIFAECHER = "SELECT * FROM uv_optional_course WHERE semester_id = ?;";
		List<NamedCourse> f = new ArrayList<NamedCourse>();

		PreparedStatement ladeFreifaecher;
		try {
			ladeFreifaecher = con.prepareStatement(LADE_FREIFAECHER);
			ladeFreifaecher.setLong(1, semesterId);

			ResultSet rs = ladeFreifaecher.executeQuery();

			while (rs.next()) {
				NamedCourse nc = new NamedCourse(rs.getLong("course_id"),
						rs.getString("course_name"));
				nc.setCourseOfStudiesId(rs.getLong("course_of_studies_id"));
				nc.setCourseTemplateId(rs.getLong("course_template_id"));
				nc.setSemesterId(rs.getLong("semester_id"));
				nc.setLektorId(rs.getLong("lecturer_id"));

				f.add(nc);
			}

			return f;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not load optional courses");
			return null;
		}

	}

	@Override
	public boolean assignStudentToCourse(long studentId, long courseId) {
		String ASSIGN_STUDENT_TO_COURSE = "{call usp_register_optional_course(?,?,?)}";
		try {
			CallableStatement cs = con.prepareCall(ASSIGN_STUDENT_TO_COURSE);

			cs.setLong(1, studentId);
			cs.setLong(2, courseId);

			cs.registerOutParameter(3, java.sql.Types.INTEGER);

			cs.executeUpdate();

			int erg = cs.getInt(3);

			if (erg == 0)
				return true;
			else if (erg == -1)
				return false;
			else {
				System.out
						.println("Couldnt assign student to course, there are already to many!");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to assign student!");
			return false;
		}
	}

	@Override
	public List<Studiengang> ladeStudiengaenge() {
		String LADE_STUDIENGAENGE = "SELECT * FROM tb_course_of_studies;";
		List<Studiengang> s = new ArrayList<Studiengang>();
		try {
			PreparedStatement ladeStudiengaenge = con
					.prepareStatement(LADE_STUDIENGAENGE);

			ResultSet rs = ladeStudiengaenge.executeQuery();

			while (rs.next()) {
				Studiengang st = new Studiengang();
				st.setId(rs.getLong("id"));
				st.setLecturer_id(rs.getLong("tb_lecturer_id"));
				st.setName(rs.getString("name"));
				st.setNr(rs.getLong("nr"));
				st.setParticipants(rs.getLong("participants"));
				st.setDegree(rs.getString("degree"));

				s.add(st);
			}

			return s;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to load studiengaenge!");
			return null;
		}
	}

	@Override
	public List<String> ladeGehaltsklassen() {
		String LADE_GEHALTSKLASSEN = "SELECT name FROM tb_salary_class";
		List<String> g = new ArrayList<String>();

		try {
			PreparedStatement getGehaltsklassen = con
					.prepareStatement(LADE_GEHALTSKLASSEN);

			ResultSet rs = getGehaltsklassen.executeQuery();

			while (rs.next()) {
				g.add(rs.getString("name"));
			}

			return g;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not load salary classes");
			return null;
		}

	}

	@Override
	public List<Lektor> ladeAlleLektoren() {
		String LADE_LEKTOREN = "SELECT * FROM uv_get_lecturers;";
		List<Lektor> l = new ArrayList<Lektor>();

		try {
			PreparedStatement getLektoren = con.prepareStatement(LADE_LEKTOREN);

			ResultSet rs = getLektoren.executeQuery();

			while (rs.next()) {
				Lektor le = new Lektor();
				le.setId(rs.getLong("lecturer_id"));
				le.setFirstname(rs.getString("firstname"));
				le.setLastname(rs.getString("lastname"));
				le.setAdress(rs.getString("adress"));
				le.setZip(rs.getString("zip"));
				le.setTelefon(rs.getString("telefon"));
				le.setEmail(rs.getString("email"));
				le.setToken(rs.getString("token"));
				le.setGehaltsklasse(rs.getString("salary_class_name"));

				l.add(le);
			}

			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not load lecteures!");
			return null;
		}

	}

	@Override
	public List<Semester> ladeAlleSemester() {
		String LADE_SEMESTER = "SELECT * FROM tb_semester;";
		List<Semester> s = new ArrayList<Semester>();

		try {
			PreparedStatement ladeSemester = con
					.prepareStatement(LADE_SEMESTER);

			ResultSet rs = ladeSemester.executeQuery();

			while (rs.next()) {
				Semester se = new Semester();
				se.setId(rs.getLong("id"));
				se.setToken(rs.getString("token"));
				se.setStart_day(rs.getString("start_day"));
				se.setEnd_day(rs.getString("end_day"));

				s.add(se);
			}

			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to load semesters!");
			return null;
		}

	}

	@Override
	public List<Template> ladeAlleTemplate() {
		String LADE_TEMPLATES = "SELECT * FROM tb_course_template;";
		List<Template> t = new ArrayList<Template>();

		PreparedStatement ladeTemplates;
		try {
			ladeTemplates = con.prepareStatement(LADE_TEMPLATES);
			ResultSet rs = ladeTemplates.executeQuery();

			while (rs.next()) {
				Template te = new Template();

				te.setId(rs.getLong("id"));
				te.setCourseOfStudiesId(rs.getLong("tb_course_of_studies_id"));
				te.setSemester(rs.getLong("semester"));
				te.setName(rs.getString("name"));
				te.setToken(rs.getString("token"));
				te.setParticipants(rs.getLong("participants"));
				te.setEcts(rs.getDouble("ects"));
				te.setSws(rs.getDouble("sPPW"));

				t.add(te);
			}

			return t;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to load templates!");
			return null;
		}

	}

	@Override
	public List<GradedStudent> ladeStudenten(long courseId) {
		String LADE_GRADES_OF_STUDENTS = "SELECT * FROM uv_get_grades WHERE course_id = ?;";
		List<GradedStudent> gs = new ArrayList<GradedStudent>();

		try {
			PreparedStatement getGradedStudents = con
					.prepareStatement(LADE_GRADES_OF_STUDENTS);
			getGradedStudents.setLong(1, courseId);

			ResultSet rs = getGradedStudents.executeQuery();

			while (rs.next()) {
				GradedStudent gst = new GradedStudent();
				gst.setId(rs.getLong("student_id"));
				gst.setFirstname(rs.getString("firstname"));
				gst.setLastname(rs.getString("lastname"));
				gst.setGrade(rs.getInt("grade"));

				gs.add(gst);
			}

			return gs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not load graded students!");
			return null;
		}
	}

	@Override
	public List<NamedCourse> ladeAlleLvs() {
		String LADE_LVS = "SELECT cs.id, ct.name, cs.tb_course_of_studies_id,"
				+ " cs.tb_course_template_id, cs.tb_semester_id, cs.tb_lektor_id"
				+ " FROM tb_course cs INNER JOIN tb_course_template ct "
				+ "ON cs.tb_course_template_id = ct.id;";
		List<NamedCourse> lvs = new ArrayList<NamedCourse>();

		PreparedStatement ladeLvs;
		try {
			ladeLvs = con.prepareStatement(LADE_LVS);
			ResultSet rs = ladeLvs.executeQuery();

			while (rs.next()) {
				NamedCourse lv = new NamedCourse(rs.getLong("id"),
						rs.getString("name"));

				lv.setCourseOfStudiesId(rs.getLong("tb_course_of_studies_id"));
				lv.setCourseTemplateId(rs.getLong("tb_course_template_id"));
				lv.setSemesterId(rs.getLong("tb_semester_id"));
				lv.setLektorId(rs.getLong("tb_lektor_id"));

				lvs.add(lv);
			}

			return lvs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to load lvs!");
			return null;
		}

	}

	@Override
	public List<Room> ladeAlleRaeume() {
		String LADE_RAEUME = "SELECT * FROM tb_room;";
		List<Room> r = new ArrayList<Room>();

		PreparedStatement ladeRaeume;
		try {
			ladeRaeume = con.prepareStatement(LADE_RAEUME);
			ResultSet rs = ladeRaeume.executeQuery();

			while (rs.next()) {
				Room ro = new Room(rs.getString("name"));

				ro.setId(rs.getLong("id"));
				ro.setBuildingId(rs.getLong("tb_building_id"));
				ro.setToken(rs.getString("token"));
				ro.setFloor(rs.getString("floor"));

				r.add(ro);
			}

			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to load rooms!");
			return null;
		}

	}

	@Override
	public List<Student> ladeAlleStudenten() {
		String LADE_STUDENTEN = "SELECT s.id, p.firstname, p.lastname, s.tb_course_of_studies_id,"
				+ " s.studentnr, s.token, p.adress, p.zip, p.telefon, p.email FROM tb_student s "
				+ "INNER JOIN tb_person p ON s.tb_person_id = p.id;";
		List<Student> s = new ArrayList<Student>();

		PreparedStatement ladeStudenten;
		try {
			ladeStudenten = con.prepareStatement(LADE_STUDENTEN);
			ResultSet rs = ladeStudenten.executeQuery();

			while (rs.next()) {
				Student st = new Student(rs.getString("firstname"),
						rs.getString("lastname"), rs.getLong("id"));

				st.setAdress(rs.getString("adress"));
				st.setZip(rs.getString("zip"));
				st.setTelefon(rs.getString("telefon"));
				st.setEmail(rs.getString("email"));
				st.setStudiengangId(rs.getLong("tb_course_of_studies_id"));
				st.setStudentnr(rs.getLong("studentnr"));
				st.setToken(rs.getString("token"));

				s.add(st);
			}

			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to load students!");
			return null;
		}
	}

}
