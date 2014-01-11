package at.technikum.wien.bif12.dbs.verwaltung.entities;

import java.util.List;

public class Anwesenheitsliste {

	private String lehrveranstaltung;

	private List<String> names;

	public String getLehrveranstaltung() {
		return lehrveranstaltung;
	}

	public void setLehrveranstaltung(String lehrveranstaltung) {
		this.lehrveranstaltung = lehrveranstaltung;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}
