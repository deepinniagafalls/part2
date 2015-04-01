package code;

import java.util.ArrayList;

import code.util.ReaderTool;

public class Game {

	public static void main(String[] args) {
		
		Scrabble scrabble = new Scrabble();
		BoardFrame f = new BoardFrame(scrabble);
		PlayerFrame tr = new PlayerFrame(scrabble);
		ReaderTool r = new ReaderTool();
		System.out.println(r.getWords());
	}
}
