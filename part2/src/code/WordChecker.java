package code;

import code.util.ReaderTool;

public class WordChecker {
	private ReaderTool _r;
	public boolean isThisWord(String s){
		return _r.isThisAWord(s);
	}

}
