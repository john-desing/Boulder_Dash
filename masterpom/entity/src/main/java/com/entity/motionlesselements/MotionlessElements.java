package com.entity.motionlesselements;

import entity.Entity;
import entity.Sprite;

/**
 * The MotionlessElements abstract class.
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 */
public abstract class MotionlessElements extends Entity {

	/**
	 * The MotionlessElements constructor
	 * @param sprite the default sprite of the entity
	 * @param x the initial x of the motionless entity
	 * @param y the initial y of the motionless entity
	 */
	public MotionlessElements(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}
}
