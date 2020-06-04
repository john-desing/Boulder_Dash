package entity;


import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Air class
 * @author Israel BALOG
 * @since 20-05-20
*/

public class  Air extends Entity {
	
	/**
	 * Constructor of the Void class initializes the parameters of the Void.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y

	 */
	public  Air (int X , int Y) {
		this.canBeDestroyed = true;
		this.canBePushed = true;
		try {
			spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/air.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		this.posX = X;
		this.posY = Y;
	}
}
