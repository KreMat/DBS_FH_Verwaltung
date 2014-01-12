package at.technikum.wien.bif12.dbs.verwaltung.entities;

import java.sql.Date;

public class NamedLesson extends Lesson {

	private String courseName;

	private String roomName;

	public NamedLesson(String courseName, String roomName, Date startTime,
			Date endTime) {
		super();
		this.courseName = courseName;
		this.roomName = roomName;
		setStartTime(startTime);
		setEndTime(endTime);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
