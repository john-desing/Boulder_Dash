package model;

import model.DisplayableElementModel;


/**
 * Wall
 *
 * Represents the wall
 *
 * @author      John medy MBOKO
 * @since       20-05-2020
 */
public class Wall extends DisplayableElementModel {
	private static String spriteName;
	private static boolean isDestructible;
	private static boolean canMove;
	private static boolean impactExplosive;
	private static boolean animate;
	private static int priority;
	private static boolean falling;
	private static String collideSound;

    /**
     * Static dataset
     * Specifies the physical parameters of the object
     */
	static {
		spriteName = "steelwall";
		isDestructible = false;
		canMove = false;
		impactExplosive = false;
		animate = false;
		priority = 3;
		falling = false;
		collideSound = "touch";
	}

    /**
     * Class constructor
     */
	public Wall() {
		super(isDestructible, canMove, spriteName, priority, impactExplosive, animate, falling, collideSound);
		this.loadSprite(spriteName);
	}
}
