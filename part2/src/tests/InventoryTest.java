package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Inventory;
import code.Tile;

public class InventoryTest {

	@Test
	public void creates400Tiles() {
		Inventory inv = new Inventory();
		int actual = inv.size();
		int expected = 400; 
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual);
	}//Test if 400 are created in inventory class
	
	@Test
	public void gettingATileRemovesIt()
	{
		Inventory inv = new Inventory();
		inv.getTile();
		int actual = inv.size();
		int expected = 399; 
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual);
	}//Test if tile is removed from inventory when taken from inventory
	

}
