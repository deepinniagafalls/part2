package code;

public class Game {

	public static void main(String[] args) {
		try{
		Scrabble scrabble = new Scrabble();
		Frame f = new Frame(scrabble);
		}
		catch(NullPointerException e){
			System.out.println("Fix this later");
		}

	}
}
