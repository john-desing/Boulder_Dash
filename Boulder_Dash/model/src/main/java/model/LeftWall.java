package model;

import model.DisplayableElementModel;


/**
 * LeftWall
 *
 * Represents a ExpandingWall in the game.
 *
 * @author      John Medy MBOKO
 * @since       20-05-2020
 */
public class LeftWall extends DisplayableElementModel {
	private static String spriteName;
	private static boolean destructible;
	private static boolean canMove;
	private static boolean impactExplosive;
	private static boolean animate;
	private static int priority;
	private static boolean falling;
	private static String collideSound;
	
	/*
    * Static dataset
    * Specifies the physical parameters of the object
    */
	static {
		spriteName = "expandingwall";
		destructible = false;
		canMove = false;
		impactExplosive = false;
		animate = false;
		priority = 10;
		falling = false;
		collideSound = null;
	}
	
    /**
     * Class constructor
     */
	public LeftWall() {
		super(destructible, canMove, spriteName, priority, impactExplosive, animate, falling, collideSound);
		this.loadSprite(spriteName);
	}
}