package model;

import java.sql.SQLException;
import java.util.Observable;

import com.databaseconnection.DBConnection;

import contract.IModel;
import entity.Map;

/**
 * The Model class.
 *
 * @author  BOLOG Israel
 * @author Fruissala KANWER
 * @version 1.0
 */
public final class Model extends Observable implements IModel {

	/** The map. */
	private Map map;
	/** The number of levels */
	private final static int numberOfLevels = 7;
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = new Map();
	}

	/**
     * Gets the map.
     *
     * @return map
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Map getMap() {
		return this.map;
	}

	/**
     * Sets the map
     *
     * @param map
     *            the new map
     */
	private void setMap(final Map map) {
		this.map = map;
		this.modelNotify();
	}

	/**
     * Load the map
     *
     * @param id
     *            the id of the map
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMap(final int id) throws IndexOutOfBoundsException {
		
		if(id <= numberOfLevels) {
			try {
				final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
				this.setMap(daoMap.find(id));
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		} else {
				throw new IndexOutOfBoundsException("Incorrect id !");
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	/**
	 * Notify observers.
	 */
	public void modelNotify() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * The loop method.
	 * Executes the map loop and notify observers.
	 */
	public void loop() {

		if(this.getMap().getNumberOfDiamondsNeeded() != 0) {
			this.getMap().loop();
			this.modelNotify();
		}
	}
}
