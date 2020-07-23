package com.strategy;

import com.entity.mobileelements.MobileElements;

import entity.Entity;

/**
 * The Strategy parametric class.
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 * @param <T> the entity that is allowed to have the strategy
 */
public abstract class Strategy<T extends Entity> {
	
	/** The mobile element concerned by the strategy */
	protected MobileElements me = null;
	/** The method that contains the strategy */
	public abstract void runStrategy();
	/** The method that gives the name of the strategy */
	public abstract String returnStrategy();
}
