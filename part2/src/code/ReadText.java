package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ReadText {
	public static ArrayList<String> accept4 (){
		ArrayList<String> map = new ArrayList<String>();
		Scanner sc = new Scanner("//part2//src//code//util//words");
		
		while(sc.hasNext()){
			String s = sc.next();
			map.add(s);
		}
		return map;
	}
}
