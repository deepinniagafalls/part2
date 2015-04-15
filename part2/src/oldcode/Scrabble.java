package oldcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import oldhandlers.ActiveTileHandler;
import oldhandlers.BoardButtonHandler;
import oldhandlers.NextPlayerButtonHandler;
import oldhandlers.RackButtonHandler;
import oldhandlers.SaveButtonHandler;
import oldhandlers.TilePlacementHandler;

public class Scrabble implements Observer, Runnable {
	

	private Inventory _inv;
	private ArrayList<Player> _players;
	private Board _board;
	private static int _numberOfPlayers = 4;
	private ArrayList<JButton> _boardButtons, _rackButtons;
	private JLabel _playerLabel;
	private static Color[] _COLORS = {Color.BLUE,Color.YELLOW,Color.GREEN,Color.ORANGE,Color.RED,Color.PINK,Color.BLACK,Color.CYAN,Color.DARK_GRAY,Color.LIGHT_GRAY,Color.MAGENTA};

	public Scrabble(){
		_inv = new Inventory();
		_boardButtons = new ArrayList<JButton>();
		_rackButtons = new ArrayList<JButton>();
		_players = new ArrayList<Player>();
		_playerLabel = new JLabel();
		for (int i = 0; i < _numberOfPlayers; i++){
			_players.add(new Player(_inv,i+1,_COLORS[i]));
		}
		_board = new Board(_players,this);
		_board.addObserver(this);
		System.out.println("Welcome to Fake-Scrabble!\n"
				+ "-------------\n\n"
				+ "Basic Rules for play:"
				+ "\n\t1) You must select a Tile in your rack then click anywhere on the board to play it"
				+ "\n\t2) Click the 'NEXT PLAYER' button to switch to the next player when your turn is over"
				+ "\n\n-------------");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//Display the contents of _board on the Board
		String boardText = _board.toString();
		for (int i=0; i<boardText.length(); i++) {
			_boardButtons.get(i).setText(""+boardText.charAt(i));
		}
		
		//Display contents of current player's TileRack
		String tileRackText = _board.getCurrentPlayer().getPlayerTileRack().toString();
		for (int i=0; i<tileRackText.length(); i++) {
			_rackButtons.get(i).setText(""+tileRackText.charAt(i));
			_rackButtons.get(i).setBackground(_board.getCurrentPlayer().getColor());
		}
		
		//Display correct Tile colors
		for (int i = 0; i < _boardButtons.size(); i++){
			int row = i/20;
			int col = i%20;
			if (_board.tileExistsAtPoint(row,col)){
				_boardButtons.get(i).setBackground(_board.getTile(row,col).getColor());
			}
		}
		
		//Display current player's name & score
		_playerLabel.setText("Player "+_board.getCurrentPlayer().getPlayerNumber()+" ("+_board.getCurrentPlayer().getScore()+")");
	}
	
	@Override
	public void run() {
		//JFrame to hold everything
		JFrame window = new JFrame("Fake-Scrabble");
		
		//JPanel for the TileRack
		JPanel rack = new JPanel();
		rack.setLayout(new BoxLayout(rack, BoxLayout.X_AXIS));
		
		//Label for player's name & their Points (Inside rack JPanel)
		_playerLabel = new JLabel();
		_playerLabel.setText("Player 1 (0 Points)");
		rack.add(_playerLabel);
		
		//Handler which will record the active tile that the player will play
		ActiveTileHandler tileHandler = new ActiveTileHandler();
		
		/*
		 * Creating buttons inside the rack JPanel
		 * --represents tiles in current player's TileRack
		 */
		for (int i=0; i<12; i++) {
			JButton b = new JButton("");
			JPanel pb = new JPanel();
			pb.add(b);
			b.setPreferredSize(new Dimension(45, 35));
			b.addActionListener(new RackButtonHandler(_board, i, tileHandler));
			rack.add(pb);
			_rackButtons.add(b);
		}
		
		//Next Player button to switch players when current player is done playing tiles
		JButton nextPlayerButton = new JButton();
		nextPlayerButton.setText("NEXT PLAYER");
		nextPlayerButton.addActionListener(new NextPlayerButtonHandler(_board,this));
		
		//Next Player button to switch players when current player is done playing tiles
		JButton saveButton = new JButton();
		saveButton.setText("SAVE GAME");
		saveButton.addActionListener(new SaveButtonHandler(_board));
		
		//Handles if the player is playing words up/down or across the board
		TilePlacementHandler tph = new TilePlacementHandler();

		//Create the 20x20 board of buttons
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(20, 20, 1, 1));
		for (int i=0; i<400; i++) {
			JButton b = new JButton("");
			p.add(b);
			b.addActionListener(new BoardButtonHandler(i, _board, tileHandler,tph));
			_boardButtons.add(b);
		}
		
		//JPanel to hold the rack & board
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setPreferredSize(new Dimension(680, 690));
		
		//Put together the window
		container.add(p);
		container.add(rack);
		container.add(nextPlayerButton);
		container.add(saveButton);
		window.add(container);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		
		//Call the method that displays all the Board and Rack info in our JFrame
		update(null,null);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Scrabble());
	}

}
