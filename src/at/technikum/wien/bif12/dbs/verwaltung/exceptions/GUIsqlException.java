package at.technikum.wien.bif12.dbs.verwaltung.exceptions;

public class GUIsqlException extends Exception {

	private static final long serialVersionUID = -3444469261673173712L;

	public GUIsqlException(String message, Exception e) {
		super(message, e);
	}

}
