package at.technikum.wien.bif12.dbs.verwaltung.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class HomeView extends JFrame {

	private static final long serialVersionUID = -7451739232310580218L;

	/**
	 * Baut die Seite auf
	 */
	public void init() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		generateMenu();
		showData(c);
		this.setTitle("Stundenplanverwaltung");
		this.setSize(600, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void showData(Container c) {
		// TODO Auto-generated method stub

	}

	private void generateMenu() {
		// TODO Auto-generated method stub

	}

}
