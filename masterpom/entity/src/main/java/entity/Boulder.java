package entity;

import java.io.IOException;
/**
 * Boulder class
 * @author Israel BALOG
 * #}@since 20-05-20
 */

import javax.imageio.ImageIO;

public class Boulder extends Entity{
	
//	public int getBoulderX() {
	//	return posX;
//	}
	
	//public int getBoulderY() {
	//	return posY;
	//}
	
	/**
	 * Constructor of the Boulder class initializes the parameters of the Boulder.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y
	 */
	public Boulder(int X, int Y) {
		this.canBeDestroyed = false;
		this.canBePushed = false;
		try {
		this.spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/rock.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		this.posX = X;
		this.posY = Y;
	}
}
