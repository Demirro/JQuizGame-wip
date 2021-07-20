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

import de.uk.java.gui.GUI;

public class BoolQuestion extends Question{

	private boolean correctAnswer;
	public JButton trueButton;
	public JButton falseButton;
	
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
		trueButton = new JButton("True");
		trueButton.setActionCommand("Answer");
		buttonPanel.add(trueButton);
		falseButton = new JButton("False");
		falseButton.setActionCommand("Answer");
		buttonPanel.add(falseButton);
		super.defineJPanel();
		add(buttonPanel);
		
		validate();
	}
	
	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public String getCorrectAnswer() {
		return Boolean.toString(correctAnswer);
	}
	
	@Override
	public String toString() {
		return super.toString() + " Correct Answer: " + getCorrectAnswer();
	}
	
	@Override
	public void setActionListener(GUI gui) {
		trueButton.addActionListener(gui);
		falseButton.addActionListener(gui);
		validate();
	}

}
