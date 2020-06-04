package entity;

import java.awt.Image;
/**
 * character class
 * @author Israel BALOG
 * @since 21-05-20
*/

public abstract class Entity {

	/** The Boolean canbepushed */

	public boolean canBePushed;

/**
 * 
 * @param canBePushed
 * 		The boolean canbepushed
 */

	public void setCanBePushed(boolean canBePushed) {
		this.canBePushed = canBePushed;
	}
	public boolean canBeDestroyed;

	/** Horizontal position of the Entity */
	public int posX = 0;

	/** Vertical position of the Entity */

	public int posY = 0;

	/** Load of the sprite */

	protected Image spritePath;
	/**
	 * If the entity is falling, falling is true.
	 */
	protected Boolean falling;
/**
 * 
 * @return
 * 	The boolean falling
 */	
	public Boolean getFalling() {
		return falling;
	}
/**
 * 	Set the boolean falling if an entity is falling
 * @param falling
 * 		A boolean
 */
	public void setFalling(Boolean falling) {
		this.falling = falling;
	}

	/**
	 * 
	 * 
	 * @return the Image of the entity
	 */

	public Image getSpritePath() {
		return spritePath;
	}
/**
 * 
 * @return
 * 		A boolean if the entity canbepushed
 */	


	public boolean getCanBePushed() {
		return canBePushed;
	}
/**
 * 
 * @return
 * 		A boolean if the entity can be destroyed
 */	
	public boolean getCanBeDestroyed() {
		return canBeDestroyed;
	}

}
