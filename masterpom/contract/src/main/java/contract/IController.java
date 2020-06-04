package contract;

import java.awt.Image;

import entity.Entity;

/**
 * The Interface IController.
 *
 * @author John Medy MBOKO
 * @since 20-05-2020
 */
public interface IController {

	/**
	 * Control
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	
	public void orderPerform(ControllerOrder controllerOrder);
	
	//public void swap(Entity[][] tabEntity, Image[][] tabImage, int i);
	
	/**
	 * Initiate the movement and create the exit door
	 * 
	 * @param KeyCode
	 * 			The code of the Keypressed
	 */
	
	public void movement(int KeyCode);
	
	/**
	 * 
	 * @return
	 * 		The current model
	 */
	public IModel getModel();
}
