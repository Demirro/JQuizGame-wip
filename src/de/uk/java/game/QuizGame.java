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
	
	Game game;
	public QuizGame() {
		UiCallbacks uiCallbacks = new UiCallbacks() {
			
			@Override
			public Game newGame() {
				game = new Game();
				return game;
			}

			@Override
			public Game checkAnswer(String string) {
				return game.checkAnswer(string);
			}
		};
		new GUI(uiCallbacks);
	}
}
