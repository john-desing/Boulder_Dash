package entity;

import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * character class
 * @author Israel BALOG
 * @since 19-05-20
*/


public class Character extends Entity{
	
	
	int nbDiamond;
	/**
	 * 
	 * @return
	 * 		The number of diamond the character caught
	 */	
	public int getNbDiamond() {
		return nbDiamond;
	}
	/**
	 * 
	 * @param nbDiamond
	 * 			The number of diamonds
	 */
	
	public void setNbDiamond(int nbDiamond) {
		this.nbDiamond = nbDiamond;
	}
	/**
	 * Constructor of the Character class initializes the parameters of the Character.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y
	 */
	
	public Character(int X, int Y) {
		this.nbDiamond = 0;
	//	this.canBeDestroyed = true;
		//this.canBePushed = false;
		try {
			this.spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/Player.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		this.posX = X;
		this.posY = Y;
	}
}
