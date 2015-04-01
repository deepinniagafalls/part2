package code.util;

import java.util.ArrayList;

public class VerifyWords {
	String _words = "";
	ArrayList<String> _s = new ArrayList<String>();
	
	public VerifyWords(){
		ReaderTool r = new ReaderTool();
		_s = r.getWords();
	}
	
	public void setString(String s){
		_words = s;
	}
	public Boolean verify(){
	    for (String s : _s){
	    	
	    }
		int state = 0;
		return false;
	}
}
