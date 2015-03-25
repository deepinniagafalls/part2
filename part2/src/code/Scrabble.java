package code;

import java.util.ArrayList;

/**
 * Scrabble creates the board and inventory as well as facilitates the addition
 * of players. At present, it also handle initiating and completing the game.
 * Later, a turn/gameplay handler may be necessary.
 * @author t020
 *
 */
public class Scrabble {
	
	private Board _board;
	private Inventory _inventory;
	private ArrayList<Player> _players;
	private boolean _playing;
	private int _playerCount;
	private int _passCount;
	
	/**
	 * The default constructor for a new Scrabble. Creates a board and an inventory.
	 */
	public Scrabble()
	{
		_inventory = new Inventory();
		_board = new Board();
		_players = new ArrayList<Player>();
		Frame frame = new Frame();
	}
	
	/**
	 * Adds a player to the game
	 * @return true if added successfully
	 */
	public boolean addPlayer()
	{
		_playerCount++;
		_players.add(new Player(_inventory, _board));

		return true;
	}
	
	/**
	 * Removes a player from the game
	 * @param p player to remove
	 * @return true if removed successfully
	 */
	public boolean removePlayer(Player p)
	{
		_playerCount--;

		return _players.remove(p);
	}
	
	/**
	 * This initiates the main game loop.
	 */
	public void startGame()
	{
		
	}
	
	/**
	 * Ends the game and announces the winner. Additionally clears the board,
	 * creates a new inventory, and resets the players.
	 */
	public void endGame()
	{
		Player winning = new Player(_inventory, _board);
		
		for(Player p : _players)
		{
			if(p.getScore() > winning.getScore())
				winning = p;
		}
		
		System.out.println(winning.getName() + " wins!");
		
		_playing = false;
		_board.wipeBoard();
		_inventory = new Inventory();
		_players = new ArrayList<Player>();
		
	}
	
	/**
	 * Returns the amount of players in the game
	 */
	public int getPlayerCount(){
		return _playerCount;
	}
}
