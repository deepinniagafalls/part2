package code;

import java.util.LinkedList;

import code.base.Board;
import code.util.ReaderTool;

public class WordChecker {
	
	private ReaderTool _r;
	private LinkedList _word;
	private BoardFrame _bf;
	private Board _b;
	
	public WordChecker(BoardFrame boardframe, Board board){
		_word = new LinkedList<String>();
	}
	
	public boolean isThisWord(String s){
		return _r.isThisAWord(s);
	}
	
	public void addWord(){
		
	}

}
