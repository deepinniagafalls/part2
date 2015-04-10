package code.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderTool_047 {
	private ArrayList<String> _words;
	public ReaderTool_047(){
	_words = new ArrayList<String>();
    String  _line = null;
    try{
       BufferedReader br = new BufferedReader(new FileReader("res/words.txt"));
       while ((_line = br.readLine()) != null) {
          _words.add(_line);
       }       
    }
    catch(Exception e){}
	}
	public ArrayList<String> getWords(){
		return _words;
	}
	public boolean isThisAWord(String s){
		return _words.contains(s);
		
	}
}
