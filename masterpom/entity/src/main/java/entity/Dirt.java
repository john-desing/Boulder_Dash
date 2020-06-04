package entity;

import java.io.IOException;


import javax.imageio.ImageIO;
/**
 * Dirt class
 * @author Israel BALOG
 * @since 19-05-20
*/


public class Dirt extends Entity{
	
	/**
	 * Constructor of the Dirt class initializes the parameters of the Dirt.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y

	 */
	public Dirt(int X, int Y) {
		this.canBeDestroyed = true;
		this.canBePushed = false;
		try {
			this.spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/dirt.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		this.posX = X;
		this.posY = Y;
	}
}
