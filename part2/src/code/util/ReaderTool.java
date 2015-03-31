package code.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderTool {
	private ArrayList<String> _words;
	public ReaderTool(){
	_words = new ArrayList<String>();
    String  thisLine = null;
    try{
       BufferedReader br = new BufferedReader(new FileReader("/part2/src/code/util/words/words.txt"));
       while ((thisLine = br.readLine()) != null) {
          _words.add(thisLine);
       }       
    }
    catch(Exception e){
       e.printStackTrace();
    }
	}
	public ArrayList<String> getWords(){
		return _words;
	}
}
