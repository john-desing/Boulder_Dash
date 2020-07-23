package com.entity.motionlesselements;

import java.io.IOException;

import entity.Sprite;

/**
 * The Walls class.
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 */
public class Walls extends MotionlessElements {
	
	/**
	 * The Wall's default sprite
	 */
	private static final Sprite sprite = new Sprite('q',"Wall.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The Wall's constructor.
	 * @param x the x of the wall
	 * @param y the y of the wall
	 */
	public Walls(int x, int y) {
		super(sprite, x, y);
	}
	
	

}
