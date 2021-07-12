package de.uk.java.questions;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Question extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private String category; // maybe Enums
	private String prompt;
	
	public Question (String category, String prompt) {
		setCategory(category);
		setPrompt(prompt);
	}
	
	/**
	 * Aufsetzen der Fragenanzeige in der GUI
	 */
	protected void defineJPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel questionHeader = new JPanel();
		questionHeader.setLayout(new BoxLayout(questionHeader, BoxLayout.PAGE_AXIS));
		JLabel category = new JLabel(getCategory());
		JLabel prompt = new JLabel(getPrompt());
		
		category.setAlignmentX(CENTER_ALIGNMENT);
		prompt.setAlignmentX(CENTER_ALIGNMENT);
			
		questionHeader.add(category);
		questionHeader.add(prompt);
		
		add(questionHeader);
		validate();
		//setSize(400, 400);
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Prompt: " +getPrompt() + " Category: " + getCategory();
	}
	
	public abstract void checkAnswer(String actionCommand);
}
