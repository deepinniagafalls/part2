package code;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

public class Frame extends JFrame {
	
	
    private final int WIDTH = 600;
    private final int HEIGHT = 500;
    private Scrabble _s;
    private Inventory _inv;
    private ArrayList<Player> _players;
	private Board _board;
	private int _numberOfPlayers;
	
	public Frame(Scrabble s){
		_s = s;
		JFrame mainframe = new JFrame();
		setSize(WIDTH, HEIGHT);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.pack();
		setVisible(true);
		
	}
	public void update(){
		_inv = _s.getInv();
		_players = _s.getPlayer();
		_board = _s.getBoard();
		_numberOfPlayers = _s.getNumofPlayers();
	}

}

