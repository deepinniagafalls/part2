package oldcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class Board extends Observable{

	private Tile[][] _board;
	private ArrayList<Player> _players;
	private ArrayList<Tile> _activePlayerTiles;
	private static Scrabble _MAIN;
	private boolean _tileHasBeenPlaced;

	public Board(ArrayList<Player> arrayList, Scrabble s){
		_board = new Tile[20][20];
		_players = arrayList;
		_activePlayerTiles = new ArrayList<Tile>();
		_MAIN = s;
		_tileHasBeenPlaced = false;
	}

	public void addTile(Tile t, int row, int col){
		t.setPlayer(getCurrentPlayer());
		t.setXCoord(col);
		t.setYCoord(row);
		_board[row][col] = t;
		getCurrentPlayer().setScore(getCurrentPlayer().getScore()+t.getValue());
		System.out.println("Player "+getCurrentPlayer().getPlayerNumber()+" played "+t.getChar()+" at ("+col+","+row+")");
		_activePlayerTiles.add(t);
		
		setChanged();
		notifyObservers();
	}
	
	public boolean checkPlayedTilesForValidWord(){
		if (_activePlayerTiles.size()==0){
			return true;
		}
		
		if (_activePlayerTiles.size()>1){
			int xCoord1 = _activePlayerTiles.get(0).getXCoord();
			int yCoord1 = _activePlayerTiles.get(0).getYCoord();
			int xCoord2 = _activePlayerTiles.get(1).getXCoord();
			int yCoord2 = _activePlayerTiles.get(1).getYCoord();
			String word = "";
			
			if (xCoord1==xCoord2 && yCoord1!=yCoord2){
				//Column word
				//Find the "top" most letter of the word then the "bottom" most letter
				int topIndex = yCoord1;
				int bottomIndex = yCoord1;
				while ( (topIndex>0 && tileExistsAtPoint(topIndex-1,xCoord1)) || (topIndex==0 && tileExistsAtPoint(19,xCoord1)) ){
					if (topIndex==0){
						topIndex = 19;
					} else {
						topIndex = topIndex-1;
					}
				}
				while ( (bottomIndex<19 && tileExistsAtPoint(bottomIndex+1,xCoord1)) || (bottomIndex==19 && tileExistsAtPoint(0,xCoord1)) ){
					if (bottomIndex==19){
						bottomIndex = 0;
					} else {
						bottomIndex = bottomIndex+1;
					}
				}
				while (topIndex != bottomIndex){
					word = word + getTile(bottomIndex,xCoord1).getChar();
					if (bottomIndex == 0){
						bottomIndex = 19;
					} else {
						bottomIndex = bottomIndex - 1;
					}
				}
				word = word + getTile(topIndex,xCoord1).getChar();
			} else if (xCoord1!=xCoord2 && yCoord1==yCoord2){
				//Row word
				//Find the "left" most letter of the word then the "right" most letter
				int leftIndex = xCoord1;
				int rightIndex = xCoord1;
				while ( (rightIndex<19 && tileExistsAtPoint(yCoord1,rightIndex+1)) || (rightIndex==19 && tileExistsAtPoint(yCoord1,0)) ){
					if (rightIndex==19){
						rightIndex = 0;
					} else {
						rightIndex = rightIndex+1;
					}
				}
				while ( (leftIndex>0 && tileExistsAtPoint(yCoord1,leftIndex-1)) || (leftIndex==0 && tileExistsAtPoint(yCoord1,19)) ){
					if (leftIndex==0){
						leftIndex = 19;
					} else {
						leftIndex = leftIndex-1;
					}
				}
				while (leftIndex != rightIndex){
					word = word + getTile(yCoord1,leftIndex).getChar();
					if (leftIndex == 19){
						leftIndex = 0;
					} else {
						leftIndex = leftIndex + 1;
					}
				}
				word = word + getTile(yCoord1,leftIndex).getChar();
			}
			try {
				return checkword(word);
			} catch (IOException e) {
				System.out.println(e);
			}
			System.out.println("Something went wrong");
		}
		return false;
	}
	
	private boolean checkword(String word) throws IOException {
		String reversedStr = new StringBuilder(word).reverse().toString();
		try (BufferedReader br = new BufferedReader(new FileReader("gamedata/englishwords"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if (line.toUpperCase().equals(word) || line.toUpperCase().equals(reversedStr)){
					System.out.println("Player "+getCurrentPlayer().getPlayerNumber()+" played "+word+" ("+reversedStr+")");
					return true;
				}
		    }
		}
		System.out.println(word+" ("+reversedStr+") isnt a word");
		return false;
	}
	
	public boolean tileBelongsToCurrentActivePlayer(Tile t){
		for (Tile tile : _activePlayerTiles){
			if (tile==t){
				return true;
			}
		}
		return false;
	}
	
	public void nextPlayer(){
		_activePlayerTiles = new ArrayList<Tile>();
		_players.add(_players.remove(0));
		_tileHasBeenPlaced = true;
	}
	
	public Player getCurrentPlayer(){
		return _players.get(0);
	}

	public Tile removeTile(int row, int col){
		Tile temp = _board[row][col];
		_board[row][col] = null;
		_activePlayerTiles.remove(temp);
		getCurrentPlayer().setScore(getCurrentPlayer().getScore()-temp.getValue());
		return temp;
	}
	
	public ArrayList<Tile> getActiveTiles(){
		return _activePlayerTiles;
	}

	public Tile getTile(int row, int col){
		return _board[row][col];
	}
	
	public boolean tileExistsAtPoint(int row, int column){
		return getTile(row,column)!=null;
	}
	
	public void updateBoard(){
		_MAIN.update(null,null);
	}
	
	public boolean tileHasBeenPlaced(){
		return _tileHasBeenPlaced;
	}
	
	public ArrayList<Player> getPlayers(){
		return _players;
	}
	
	@Override public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<_board.length; i++) {
			for (int j=0; j<_board[i].length; j++) {
				Tile who = _board[i][j];
				if (who == null) {
					sb.append(' ');
				}
				else {
					sb.append(Character.toString(who.getChar()));
				}
			}
		}
		return sb.toString();
	}

}
