package code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SaveGame {
	
	public static void main( String arg[]){
		SaveGame s = new SaveGame();
	}

	public void Save(String s){
		
		String save = s;
		save.concat("Game.java");
		 try {
		        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(save));
		        oos.writeObject(oos);
		        oos.close();
		    } catch(Exception ex) {
		        ex.printStackTrace();
		    }
	}
	public void Load(String s){
		
	    if(s.contains("Gave.java")){
	        try {
	        	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(s));
	        	SaveGame sg = (SaveGame)ois.readObject();
	        	ois.close();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}


