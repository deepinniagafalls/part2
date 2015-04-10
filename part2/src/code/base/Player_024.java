package code.base;

import java.awt.Color;
import java.util.Random;


public class Player_024 {

	/**
	 * Records the score.
	 */
	private int _score;
	
	/**
	 * Allows the Player to access the Tiles on its own TileRack.
	 */
	private TileRack_024 _rack;
	//private Inventory _inv;
	
	private Color _myColor;
	
	private String _myName;
	
	
	/**
	 * Class constructor.
	 * 
	 * @param inv can draw Tiles from the Inventory
	 */
	public Player_024(Inventory_024 inv, String name){
		_score = 0;
		//_inv = inv;
		_rack = new TileRack_024(inv);
		Random random = new Random();
		float hue = random.nextFloat();
		float saturation = (random.nextFloat() * 1.0f) + 0.6f;
		float luminance = (random.nextFloat() * 1.1f) + 0.7f; 
		_myColor = Color.getHSBColor(hue, saturation, luminance);
		_myName = name;
	}
	/**
	 * Gets the int value of the Player's score.
	 * 
	 * @return Player's score.
	 */
	public int getScore(){
		return _score;
	}
	
	public TileRack_024 getTileRack(){
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
	
	public String getName(){
		return _myName;
	}
	
}
