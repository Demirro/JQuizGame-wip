package de.uk.java.game;

import java.io.File;
import java.io.IOException;

import de.uk.java.gui.GUI;
import de.uk.java.questions.Questions;
import de.uk.java.utils.QuestionFileReader;

public class QuizGame {

	public static void main(String[] args) {
		new QuizGame();
	}
	public QuizGame() {
		GUI gui = new GUI();
		Questions questions = new Questions();
		questions.setQuestions(QuestionFileReader.readQuestions(new File("questions.json")));
		
		System.out.println(questions.getQuestions());
		System.out.println(questions.getQuestion("Java is bad!"));
		System.out.println(questions.getQuestion(0));
		gui.getContentPane().add(questions.getQuestion(0));
	}
}
