package de.uk.java.gui;

import de.uk.java.game.Game;

public interface UiCallbacks {
	public Game newGame();
	public Game checkAnswer(String string);
}
