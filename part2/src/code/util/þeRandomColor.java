package code.util;

import java.util.Random;

public class þeRandomColor {
	
	public þeRandomColor(float r2, float g2, float b2){
		Random random = new Random();
		
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		
		þeRandomColor randomcolor = new þeRandomColor(r, g, b);
	}

}
