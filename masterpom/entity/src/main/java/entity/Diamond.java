package entity;

import java.io.IOException;


import javax.imageio.ImageIO;
/**
 * Diamond class
 * @author John-Medy-MBOKO
 * @since 19-05-20
*/


public class Diamond extends Entity{
	
	/**
	 * Constructor of the Diamond class initializes the parameters of the Diamond.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y

	 */
	
	public Diamond(int X, int Y) {
		this.canBeDestroyed = true;
		this.canBePushed = false;
		try {
			this.spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/diamond.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		this.posX = X;
		this.posY = Y;
	}
}
