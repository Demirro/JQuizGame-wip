package de.uk.java.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import de.uk.java.game.Game;


public class GUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private final Dimension prefSize = new Dimension(1000, 1000);
	
	private UiCallbacks uiCallbacks;

	public GUI(UiCallbacks uiCallbacks) {
		this.uiCallbacks = uiCallbacks;
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
		newGame.setActionCommand("new game");
		newGame.addActionListener(this);
		fileMenu.add(newGame);
		bar.add(fileMenu);
		setJMenuBar(bar);
		
		setLayout(new BorderLayout());
		
		setTitle("QuizGame"); // Fenstertitel
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Schließen-Aktion
		setPreferredSize(prefSize); // bevorz. Fenstergröße
		setResizable(false);
		pack(); // Fenstergröße anpassen
		setLocationRelativeTo(null); // Fensterposition
		setVisible(true); // Fenster anzeigen
		
	}
	
	private void displayGameState(Game game) {
		add(game.currentQuestion);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ("new game"):
			displayGameState(uiCallbacks.newGame());
		}
		
	}
	
}
