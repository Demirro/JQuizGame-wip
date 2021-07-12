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
	
	/**
	 * Eine Frage in der Liste der Fragen anhand der Aussage/des Fragensatzes finden
	 * @param prompt
	 * @return
	 */
	public Question getQuestion(String prompt) {
		for (Question question : questions) {
			if (question.getPrompt().equals(prompt)) {
				return question;
			}
		}
		return null;
	}
	/**
	 * Eine Frage in der Liste der Fragen anhand des Indizes
	 * @param prompt
	 * @return
	 */
	public Question getQuestion(int index) {
		return questions.get(index);
	}

	public int size() {
		// TODO Auto-generated method stub
		return questions.size();
	}

	public void remove(Question currentQuestion) {
		questions.remove(currentQuestion);
	}
}
