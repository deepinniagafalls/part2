package code.util;

import java.util.Random;

public class þheRandomColor {
	
	public þheRandomColor(float r2, float g2, float b2){
		Random random = new Random();
		
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		
		þheRandomColor randomcolor = new þheRandomColor(r, g, b);
	}

}
