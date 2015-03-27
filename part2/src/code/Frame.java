package code;
import java.awt.Dimension;

import javax.swing.*;

public class Frame extends JFrame {
	
	
    private final int WIDTH = 600;
    private final int HEIGHT = 500;
	
	public Frame(){
		JFrame mainframe = new JFrame();
		setSize(WIDTH, HEIGHT);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.pack();
		setVisible(true);
		
	}

}

