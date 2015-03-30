package code;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadText {
	public static ArrayList<String> accept4 (){
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc = new Scanner("//part2//src//code//util//words");
		
		while(sc.hasNext()){
			String s = sc.next();
			list.add(s);
		}
		return list;
	}
}
