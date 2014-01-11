package at.technikum.wien.bif12.dbs.verwaltung.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import at.technikum.wien.bif12.dbs.verwaltung.dao.DatabaseHandler;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Anwesenheitsliste;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Course;
import at.technikum.wien.bif12.dbs.verwaltung.entities.GradedStudent;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lektor;
import at.technikum.wien.bif12.dbs.verwaltung.entities.Lesson;
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

		try {
			PreparedStatement ladeZeugnis = con.prepareStatement(LADE_ZEUGNIS);
			ladeZeugnis.setLong(1, studenId);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public List<Course> ladeFreifacher(long semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean assignStudentToCourse(long studentId, long courseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Studiengang> ladeStudiengaenge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> ladeGehaltsklassen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lektor> ladeAlleLektoren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Semester> ladeAlleSemester() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Template> ladeAlleTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradedStudent> ladeStudenten(long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
