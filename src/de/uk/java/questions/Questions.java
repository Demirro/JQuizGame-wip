package de.uk.java.questions;

import java.util.ArrayList;

public class Questions {
	
	private ArrayList<Question> questions;

	//remove from list when answered
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	// addQuestion
	// removeQuestion
	// getQuestion(index, prompt, fragenart)
	
	public Question getQuestion(String prompt) {
		for (Question question : questions) {
			if (question.getPrompt().equals(prompt)) {
				return question;
			}
		}
		return null;
	}
	
	public Question getQuestion(int index) {
		return questions.get(index);
	}
}
