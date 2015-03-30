package code;

import java.util.ArrayList;
import java.util.Scanner;


public class ReadText {
	
	ArrayList<String> _map = new ArrayList<String>();
	
	public ReadText(){
		String fileName = "words.txt";
		Scanner sc = new Scanner(fileName);
		
		while(sc.hasNext()){
			String s = sc.next();
			_map.add(s);
		}
	}

	
	public void access(int index){
		System.out.println(_map.get(index));
	}
}
