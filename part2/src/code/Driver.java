package code;

import java.io.IOException;

import javax.swing.UnsupportedLookAndFeelException;

/*
 * This class has a main method which instantiates the game class
 */

public class Driver {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException {
		Game g = new Game("CUI");
	}
}
