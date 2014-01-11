package at.technikum.wien.bif12.dbs.verwaltung.entities;

public class Lektor {

	private String firstname;
	private String lastname;
	private String adress;
	private String zip;
	private String telefon;
	private String email;
	private String token;
	private String gehaltsklasse;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getGehaltsklasse() {
		return gehaltsklasse;
	}

	public void setGehaltsklasse(String gehaltsklasse) {
		this.gehaltsklasse = gehaltsklasse;
	}

}
