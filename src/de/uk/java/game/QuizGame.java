package de.uk.java.game;

import java.io.File;
import java.io.IOException;

import de.uk.java.gui.GUI;
import de.uk.java.gui.UiCallbacks;
import de.uk.java.questions.Questions;
import de.uk.java.utils.QuestionFileReader;

public class QuizGame {

	public static void main(String[] args) {
		new QuizGame();
	}
	public QuizGame() {
		UiCallbacks uiCallbacks = new UiCallbacks() {
			
			@Override
			public Game newGame() {
				Game game = new Game();
				return game;
			}
		};
		new GUI(uiCallbacks);
	}
}
