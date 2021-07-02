package de.uk.java.questions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BoolQuestion extends Question implements ActionListener{

	private boolean correctAnswer;
	
	public BoolQuestion(String category, String prompt, boolean correctAnswer) {
		super(category, prompt);
		setCorrectAnswer(correctAnswer);
		defineJPanel();
	}

	/**
	 * Buttons für Bool'sche Fragen in Swings aufsetzen
	 * Superconstructor der Elternklasse wo die Frage angezeigt wird, wird aufgerufen
	 */
	@Override
	protected void defineJPanel() {
		JPanel buttonPanel = new JPanel();
		JButton trueButton = new JButton("True");
		trueButton.setActionCommand("True");
		trueButton.addActionListener(this);
		buttonPanel.add(trueButton);
		JButton falseButton = new JButton("False");
		falseButton.setActionCommand("False");
		falseButton.addActionListener(this);
		buttonPanel.add(falseButton);
		super.defineJPanel();
		add(buttonPanel);
		
	}
	
	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public boolean getCorrectAnswer() {
		return correctAnswer;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Correct Answer: " + getCorrectAnswer();
	}
	
	/**
	 * Aufsetzen der Actions für die Knöpfe
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "True":
			System.out.println("true was pressed");
			checkAnswer(e.getActionCommand());
			break;
		case "False":
			System.out.println("false was pressed");
			break;
		default:
			break;
		}
		
	}

	private void checkAnswer(String actionCommand) {
		// TODO Auto-generated method stub
		
	}
	
}