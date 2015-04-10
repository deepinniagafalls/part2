package tests.base;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import code.base.Board_024;
import code.base.Tile_024;

public class BoardTest {
	@Test
	public void initializedEmptyBoardTest(){
		//test that initialized board is empty
		Board_024 b = new Board_024();
		int nullTileCount=0;
		for (int i=0; i<20; i++){
			for (int j=0; j<20;j++){
				if(b.getTile(i, j)==null){
					nullTileCount=nullTileCount+1;
				}
			}
		}
		assertTrue("I expected a new board to contain 400 empty spaces, but there were only "+nullTileCount,nullTileCount==400);
	}
	@Test
	public void addTest(){
		//test that we can add a tile to a spot
		Board_024 b = new Board_024();
		Tile_024 t = new Tile_024('y',2);
		b.addTile(t,2,2);
		assertTrue("I tried to add a tile to the board, but it wasn't there", t==b.getTile(2, 2));
	}
	//test that the correct tile is removed from a spot
	@Test
	public void removeTest(){
		Board_024 b = new Board_024();
		Tile_024 tile = new Tile_024('A', 1);
		b.addTile(tile,19,2);
		Tile_024 temp=b.removeTile(19,2);
		assertTrue("I tried to remove tile "+tile+" from the board, but instead removed "+temp,tile.equals(temp));
	}
	//test that spot on board is empty after removing a tile
	@Test
	public void emptyAfterRemovalTest(){
		Board_024 b = new Board_024();
		boolean testNull=false;
		Tile_024 tile = new Tile_024('z',5);
		b.addTile(tile,7,7);
		b.removeTile(7,7);
		assertTrue("After removing a tile, the board space was not empty", b.getTile(7,7)==null);
	}

}
