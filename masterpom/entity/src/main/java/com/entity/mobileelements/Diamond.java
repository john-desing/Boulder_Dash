package com.entity.mobileelements;

import java.io.IOException;

import com.strategy.BasicFalling;

import entity.Sprite;

/**
 * The diamond class.
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 */
public class Diamond extends MobileElements {

	/**
	 * The basic sprite of a diamond.
	 */
	private static final Sprite sprite = new Sprite('x',"Diamond.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The diamond's constructor.
	 * @param x the diamond's x
	 * @param y the diamond's y
	 */
	public Diamond(int x, int y) {
		super(sprite, x, y);
		this.setStrategy(new BasicFalling(this));
	}
}
