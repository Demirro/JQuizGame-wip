package de.uk.java.questions;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.uk.java.gui.GUI;

public class SingleChoiceQuestion extends Question {

	private String correctAnswer;
	
	// get List from JSONAray and make it possible to randomize the button placement
	private List<String> answerList;
	
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	
	public JButton aButton;
	public JButton bButton;
	public JButton cButton;
	public JButton dButton;
	
	public SingleChoiceQuestion(String category, String prompt, String correctAnswer, 
			String answer1, String answer2, String answer3, String answer4) {
		super(category, prompt);
		
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		
		setCorrectAnswer(correctAnswer);
		defineJPanel();
	}
	
	@Override
	protected void defineJPanel() {
		JPanel buttonPanel = new JPanel();
		
		aButton = new JButton(answer1);
		aButton.setActionCommand("Answer");
		buttonPanel.add(aButton);
		
		bButton = new JButton(answer2);
		bButton.setActionCommand("Answer");
		buttonPanel.add(bButton);
		
		cButton = new JButton(answer3);
		cButton.setActionCommand("Answer");
		buttonPanel.add(cButton);
		
		dButton = new JButton(answer4);
		dButton.setActionCommand("Answer");
		buttonPanel.add(dButton);
		
		super.defineJPanel();
		add(buttonPanel);
		
		validate();
	}

	private void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	@Override
	public void setActionListener(GUI gui) {
		aButton.addActionListener(gui);
		bButton.addActionListener(gui);
		cButton.addActionListener(gui);
		dButton.addActionListener(gui);
		validate();
	}

}
