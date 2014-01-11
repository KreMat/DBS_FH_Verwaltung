package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Student extends AbstractDatabaseObject {

	private String firstname;
	private String lastname;
	private String adress;
	private String zip;
	private String telefon;
	private String email;
	private long studiengangId;
	private long studentnr;

	private String token;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getStudentnr() {
		return studentnr;
	}

	public void setStudentnr(long studentnr) {
		this.studentnr = studentnr;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getStudiengangId() {
		return studiengangId;
	}

	public void setStudiengangId(long studiengangId) {
		this.studiengangId = studiengangId;
	}

}
