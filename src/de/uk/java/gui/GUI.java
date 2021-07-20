package de.uk.java.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import de.uk.java.game.Game;
import de.uk.java.questions.Question;


public class GUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private final Dimension prefSize = new Dimension(500, 500);
	
	JPanel gameInfoPanel;
	JLabel score;
	JLabel livesLeft;
	JPanel questionPanel;
	
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
		
		setLayout(new BorderLayout());
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.setActionCommand("new game");
		newGame.addActionListener(this);
		fileMenu.add(newGame);
		bar.add(fileMenu);
		setJMenuBar(bar);
		
		JPanel pageStartPanel = new JPanel();
		JLabel pageStart = new JLabel("Dies ist eine Frage");
		
		pageStartPanel.add(pageStart);
		add(pageStartPanel, BorderLayout.PAGE_START);
		
		questionPanel = new JPanel();
		add(questionPanel, BorderLayout.CENTER);
		
		gameInfoPanel = new JPanel();
		score = new JLabel();
		gameInfoPanel.add(score);
		livesLeft = new JLabel();
		gameInfoPanel.add(livesLeft);
		add(gameInfoPanel, BorderLayout.PAGE_END);
		

		
		setTitle("QuizGame"); // Fenstertitel
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Schließen-Aktion
		setPreferredSize(prefSize); // bevorz. Fenstergröße
		setResizable(false);
		pack(); // Fenstergröße anpassen
		setLocationRelativeTo(null); // Fensterposition
		setVisible(true); // Fenster anzeigen
		
	}
	
	private void displayGameState(Game game) {
		questionPanel.removeAll();
		game.currentQuestion.setActionListener(this);
		questionPanel.add(game.currentQuestion);
		score.setText("Your current score is: " + Integer.toString(game.getCorrectAnswers()));
		livesLeft.setText("You have " + game.getLivesLeft() + " lives left");
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ("new game"):
			displayGameState(uiCallbacks.newGame());
			break;
		case ("Answer"):
			displayGameState(uiCallbacks.checkAnswer(((JButton) e.getSource()).getText()));
			break;
		default:
			break;
			}
			
		}
		
	}	
