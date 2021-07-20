package de.uk.java.game;

import java.awt.Button;
import java.io.File;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;

import de.uk.java.questions.Question;
import de.uk.java.questions.Questions;
import de.uk.java.utils.QuestionFileReader;

public class Game {
	
	private Questions questions = new Questions();
	private int wrongAnswers;
	private int maxWrongAnswers;
	private int correctAnswers;
	private boolean won;
	private boolean lost;
	
	public Question currentQuestion;
	
	public Game() {
		questions.setQuestions(QuestionFileReader.readQuestions(new File("questions.json")));
		wrongAnswers = 0;
		maxWrongAnswers = calculateMaxWrongAnswers();
		correctAnswers = 0;
		nextQuestion();
	}

	private void nextQuestion() {
		Random r = new Random();
		currentQuestion = questions.getQuestion(r.nextInt(questions.size()));
		questions.remove(currentQuestion);
	}

	private int calculateMaxWrongAnswers() {
		return 3;
	}

	public Game checkAnswer(String string) {
		if (string.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
		correctAnswers++;
	} else {
		wrongAnswers++;
	}
		nextQuestion();
		return this;
}
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	
	public int getLivesLeft() {
		return maxWrongAnswers - wrongAnswers;
	}
}
