package code.base;

import java.awt.Color;
import java.util.Random;


public class Player {

	/**
	 * Records the score.
	 */
	private int _score;
	
	/**
	 * Allows the Player to access the Tiles on its own TileRack.
	 */
	private TileRack _rack;
	//private Inventory _inv;
	
	private Color _myColor;
	
	/**
	 * Class constructor.
	 * 
	 * @param inv can draw Tiles from the Inventory
	 */
	public Player(Inventory inv){
		_score = 0;
		//_inv = inv;
		_rack = new TileRack(inv);
		Random random = new Random();
		float hue = random.nextFloat();
		float saturation = (random.nextFloat() * 1.0f) + 0.5f;
		float luminance = (random.nextFloat() * 1.1f) + 0.6f; 
		_myColor = Color.getHSBColor(hue, saturation, luminance);	}
	
	/**
	 * Gets the int value of the Player's score.
	 * 
	 * @return Player's score.
	 */
	public int getScore(){
		return _score;
	}
	
	public TileRack getTileRack(){
		return _rack;
	}

	
	public Color getColor(){
		return _myColor;
	}
	/**
	 * Adds the new points to the original score
	 * 
	 * @param score Score to be added to
	 * @param i additional points added to the score
	 * @return Player's score.
	 */
	public int addScore(int score, int i){
		_score = score;
		_score = _score + i;
		return _score;
	}
}