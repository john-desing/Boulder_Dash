package contract;

import java.awt.Image;
import java.util.Observable;

import entity.Character;
import entity.Entity;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

/**
 * Get the TabLine
 * @param i
 * 		The X position in the array
 * @param j
 * 		The Y position in the array
 * @return
 * 		The character at the (i, j) position in the array
 */
	String getTabLine(int i, int j);
/**
 * Get an Image of the Map
 * @param i
 * 		The X position in the array
 * @param j
 * 		The Y position in the array
 * @return
 * 		The image at the (i, j) position in the array
 */
	Image getMap(int i, int j);
/**
 * Get the Map
 * @return
 * 		The Map (all of the sprite)
 */

	Image[][] getMap();
/**
 * Get the array of Entity
 * @return
 * 		The Array of Entity (all the Entity)
 */
	Entity[][] getTabEntity();
/**
 * Set a specific position in the Array of Entity 
 * @param i
 * 		The X position in the array
 * @param j
 * 		The Y position in the array
 * @param entity
 * 		The entity added in the array
 */
	
	public void setTabEntity(int i, int j, Entity entity);
/**
 * 	Set a specific position in the Array of Image
 * @param i
 * 		The X position in the array
 * @param j
 * 		The Y position 
 * @param image
 * 		The image added in the array 
 */
	public void setMap(int i, int j, Image image);
/**
 * Get the level	
 * @return
 * 		The level the User is currently playing
 */

	int getLevel();
/**
 * Loads the Map i
 * @param i
 * 		The i
 */

	void loadMap(int i);
/**
 * Obtain the position Y of the Character
 * @return
 * 		The position Y of the Character
 */
	public int getPosY();
/**
 * 
 * @return
 * 		The position X of the Character
 */
	public int getPosX();
/**
 * Set the position Y of the Character
 * @param i
 * 		The i
 */
	public void setPosY(int i);
/**
 * Set the position X of the Character	
 * @param i
 * 		The i
 */
	public void setPosX(int i);
/**
 * @return
 * 		Obtain the Character Object	
 */
	public Character getCharacter();
/**
 * 	
 * @return
 * 		The X position of the Door
 */
	public int getDoorX();
/**
 * 	
 * @return
 * 		The Y position of the Door
 */
	public int getDoorY();
/**
 * Notify the Observers and reload the Map
 */
	public void update();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}