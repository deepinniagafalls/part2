package code;

import java.awt.FileDialog;

import javax.swing.JFrame;


@SuppressWarnings("unused")
public class SaveGame {
	
	public static void main(String[] args){
		SaveGame t = new SaveGame();
	}
	
	public SaveGame(){
		JFrame j = new JFrame();
		FileDialog chooser = new FileDialog(j);
		chooser.setDirectory("C:\\");
		chooser.setFile("*.txt");
		chooser.setVisible(true);
		String filename = chooser.getFile();
		String path = chooser.getDirectory();
		System.out.println(path);
	}
}
