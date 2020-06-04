package entity;

import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Door class
 * @author Israel BALOG
 * @since 22-05-20
*/

public class Door extends Entity{
	/**
	 * Constructor of the Diamond class initializes the parameters of the Diamond.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y

	 */
	
	public Door(int X, int Y) {
		this.canBeDestroyed = true;
		this.canBePushed = false;
		try {
			this.spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/exit.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		this.posX = X;
		this.posY = Y;
	}
}
