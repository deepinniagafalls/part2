package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class ReadText {
	
	ArrayList<String> _map = new ArrayList<String>();
	
	public ReadText(){
		Scanner sc = new Scanner("//part2//src//code//util//words");
		
		while(sc.hasNext()){
			String s = sc.next();
			_map.add(s);
		}
	}
	
	public ArrayList<String> returnlist (){
		return _map;
	}
	
	public void access(int index){
		System.out.println(_map.get(index));
	}
}
