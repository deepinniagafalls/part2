package tests;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Inventory;
import code.Tile;
import code.TileRack;

public class TileRackTest 
{
	@Test
	public void testIfAddedCorrectly()
	{
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		Tile t = new Tile('A');
		tr.returnTileToRack(t);
		
		int actual = tr.size();
		int expected = 1;
		
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual);
	}//Test if tiles are correctly added to the tile rack
	
	@Test
	public void testIfRemovedCorrectly()
	{
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		tr.returnTileToRack(null);
		tr.takeTileFromRack(null);
		
		int actual = tr.size();
		int expected = 0;
		
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual); 
	}//Test if tiles are correctly removed from the tile rack
}

