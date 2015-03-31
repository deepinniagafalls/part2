package code;

import java.util.ArrayList;

public class Game {

	public static void main(String[] args) {
		
		Scrabble scrabble = new Scrabble();
		Frame f = new Frame(scrabble);
		ArrayList<String> rt = new ReadText();
	}
}
