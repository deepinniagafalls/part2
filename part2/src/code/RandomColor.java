package code;

import java.util.Random;

public class RandomColor {
	
	public RandomColor(float r2, float g2, float b2){
		Random random = new Random();
		
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		
		RandomColor randomcolor = new RandomColor(r, g, b);
	}

}
