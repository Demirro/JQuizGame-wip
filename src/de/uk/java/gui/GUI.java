package de.uk.java.gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;


public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private final Dimension prefSize = new Dimension(1000, 1000);

	public GUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");
		fileMenu.add(newGame);
		bar.add(fileMenu);
		setJMenuBar(bar);
		
		
		
		setTitle("QuizGame"); // Fenstertitel
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Schließen-Aktion
		setPreferredSize(prefSize); // bevorz. Fenstergröße
		setResizable(false);
		pack(); // Fenstergröße anpassen
		setLocationRelativeTo(null); // Fensterposition
		setVisible(true); // Fenster anzeigen
		
	}
	
}
