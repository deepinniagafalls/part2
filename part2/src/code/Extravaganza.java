package code;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import code.base.Player;
import code.base.Scrabble;
import code.base.Tile;

public class Extravaganza extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField filename = new JTextField(), dir = new JTextField();

	private JButton open = new JButton("Open"), save = new JButton("Save");
	private JButton pass = new JButton("Pass");
	private BoardFrame _bf;
	private ArrayList<PlayerFrame> _pf;
	private Scrabble _scrabble;
	private int _currentTurn;
	private int _numberOfPlayers;
	private Game _g;
	private int _c = 0;
	private JLabel label1;

	public Extravaganza(Scrabble scrabble, BoardFrame bf, Game g, ArrayList<String> name, ArrayList<PlayerFrame> pf) throws IOException {
	      try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	      _pf = pf;
	       
	    JFrame frame = new JFrame();   
		JPanel p = new JPanel();
		_scrabble = scrabble;
		_bf = bf;
		_g = g;
		
		//p.add(filename);
		//p.add(dir);
		p.add(open);
		p.add(save);
		p.add(pass);
		open.addActionListener(new OpenL());
		save.addActionListener(new SaveL());
		pass.addActionListener(new PassT(name));
		label1 = new JLabel("Turn: " + name.get(0),null,JLabel.CENTER);
		
		
		Container cp = getContentPane();
		cp.add(p, BorderLayout.SOUTH);
		p.add(label1);
		
		dir.setEditable(false);
		filename.setEditable(false);
		p.setLayout(new GridLayout(1, 3));
		cp.add(p, BorderLayout.NORTH);
		
		
		frame.add(p);
		p.setVisible(true);
		frame.pack();
		frame.setVisible(true);
		
		
		
		
	}

	public class OpenL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			/*
			JFileChooser c = new JFileChooser();
				int value = c.showOpenDialog(Extravaganza.this);
				if (value == JFileChooser.APPROVE_OPTION) {
					filename.setText(c.getSelectedFile().getName());
					dir.setText(c.getCurrentDirectory().toString());
				}
				if (value == JFileChooser.CANCEL_OPTION) {
					filename.setText("You pressed cancel");
					dir.setText("");
				}
				c.setVisible(true);
				*/
				
				try {
					new LoadGame(_scrabble, _scrabble.getBoard(), _bf);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}

	private class SaveL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			try {
				new SaveGame(_scrabble.getBoard(), _bf, _scrabble);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*JFileChooser c = new JFileChooser();
			int value = c.showSaveDialog(Extravaganza.this);
			if (value == JFileChooser.APPROVE_OPTION) {
				filename.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if (value == JFileChooser.CANCEL_OPTION) {
			}
			c.setVisible(true);*/
		}
	}

	private static void run(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	
	private class PassT implements ActionListener {
		private ArrayList<String> _name;
		public PassT(ArrayList<String> name){
			_name = name;
		}
		
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "You have passed your turn");
			int tep = _g.getCurrentTurn();
			PlayerFrame temp = _bf.getPlayerFrame(_g.getCurrentTurn());
			for(int i=0; i<12; i++){
				if(temp.getPlayerSpace(i).getTile()==null){
					Tile t = _scrabble.getInv().removeRandomTile();
					temp.getPlayerSpace(i).setText(Character.toString(t.getChar()) + ", " + t.getValue());
					temp.getPlayerSpace(i).setCurrentTile(t);
				}
			}
			_g.incrementTurn();	
			if(_g.getCurrentTurn() == 0){label1.setText("Turn: "+ _name.get(0));}
			if(_g.getCurrentTurn() == 1){label1.setText("Turn: "+ _name.get(1));}
			if(_g.getCurrentTurn() == 2){label1.setText("Turn: "+ _name.get(2));}
			if(_g.getCurrentTurn() == 3){label1.setText("Turn: "+ _name.get(3));}
			System.out.println(_bf.getWordChecker().isThisWord());
			if(_bf.getWordChecker().isThisWord()!=null){
				String wordToScore = _bf.getWordChecker().isThisWord();
				int sum = 0;
				for(int i=0; i<wordToScore.length();i++){
					sum = sum + scoreHelper(wordToScore.charAt(i));
				}
				Player tempPlayer = _scrabble.getPlayers().get(_g.getCurrentTurn());
				tempPlayer.addScore(tempPlayer.getScore(), sum);
			}
			WordChecker check = new WordChecker(_bf,_bf.getBoard());
			_bf.setWord(check);
			(_pf.get(tep)).update();
			
		}
	}
	
	public int scoreHelper(char c){
		if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
			return 1;
		}
		if(c=='B' || c=='C' || c=='D' || c=='F' || c=='G' || c=='H' || c=='J' || c=='K' || c=='L' || c=='M' || c=='N' || c=='P' || c=='Q' || c=='R' || c=='S' || c=='T' || c=='V' || c=='W' || c=='X' || c=='Z'){
			return 5;
		}
		if(c=='Y'){
			return 2;
		}
		return 0;
	}
	

}
