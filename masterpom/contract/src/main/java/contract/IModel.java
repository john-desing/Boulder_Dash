package contract;

import java.util.Observable;

import entity.Map;



/**
 * The Interface IModel.
 *
 * @author  Fruissalla KANWER
 * @version 1.0
 */
public interface IModel {

	/**
	 * Gets the map.
	 *
	 * @return the map entity
	 */
	Map getMap();

	/**
	 * Load the map.
	 *
	 * @param id
	 *          the id of the map from the database
	 */
	void loadMap(int id);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	

	/**
	 * Notify observers.
	 */
	void modelNotify();
	
	/**
	 * Execute methods in the model to load the game.
	 */
	void loop();

}
