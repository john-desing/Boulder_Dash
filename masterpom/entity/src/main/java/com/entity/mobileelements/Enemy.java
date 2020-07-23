package com.entity.mobileelements;

import java.io.IOException;

import com.strategy.RandomEnemyMove;

import entity.Sprite;
/**
 * The Enemy class.
 *
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 */
public class Enemy extends MobileElements {

	/**
	 * The basic sprite of an enemy.
	 */
	private static final Sprite spriteDown = new Sprite('i',"Enemy.png");
	static {
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The enemy's constructor
	 * Use of DP strategy to set a specific one.
	 * @param x the initial enemy's x
	 * @param y the initial enemy's y
	 */
	public Enemy(int x, int y) {
		super(spriteDown, x, y);
		this.setStrategy(new RandomEnemyMove(this));
		this.isAlive = true;
	}
	
	/**
	 * The getSpriteDown method.
	 * @return Sprite the down sprite of the enemy
	 */
	public Sprite getSpriteDown() {
		return Enemy.spriteDown;
	}

}
