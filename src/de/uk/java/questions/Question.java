package de.uk.java.questions;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Question extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private String category; //maybe Enums
	private String prompt;
	
	public Question (String category, String prompt) {
		setCategory(category);
		setPrompt(prompt);
	}
	
	/**
	 * Aufsetzen der Fragenanzeige in der GUI
	 */
	protected void defineJPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black, 2));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new JLabel(getPrompt()));
		add(new JLabel(getCategory()));
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
}
