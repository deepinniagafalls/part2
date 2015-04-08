package code;

import java.awt.FileDialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;


@SuppressWarnings("unused")
public class SaveGame {
	
	private String _fileToWriteTo;
	
	public static void main(String[] args) throws IOException{
		SaveGame t = new SaveGame();
		t.writeNewFile();
		
	}
	
	public SaveGame() throws IOException{
	       try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
		JFrame j = new JFrame();
		FileDialog chooser = new FileDialog(j,"Save your file",FileDialog.SAVE);
		//FileDialog chooser = new FileDialog(j,"Save your file",FileDialog.LOAD);
		chooser.setDirectory("C:\\");
		chooser.setFile("*.txt");
		chooser.setVisible(true);
		String filename = chooser.getFile();
		String path = chooser.getDirectory();
		System.out.println(path);
		String filetoWrite = path + filename;
		_fileToWriteTo = filetoWrite;
		//File file = new File("/users/mkyong/filename.txt");
		
		String content = "YOOOOOOOOOOOOOOOOOOOOOOOo";
		File file = new File(_fileToWriteTo);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();
		System.out.println("Done");
		
	}
	
	public void writeNewFile() throws IOException{
		
		
	}
	
}
