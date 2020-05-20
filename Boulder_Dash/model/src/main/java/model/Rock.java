package model;

import model.DisplayableElementModel;


/**
 * Rock
 * Represents the boulders or rock
 *
 * @author      John Medy MBOKO
 * @since       20-05-2020
 */
public class Rock extends DisplayableElementModel {
	private static String spriteName;
	private static boolean isDestructible;
	private static boolean canMove;
	private static boolean impactExplosive;
	private static boolean animate;
	private static int priority;
	private static String collideSound;

    /**
     * Static dataset
     * Specifies the physical parameters of the object
     */
	static {
		spriteName = "boulder";
		isDestructible = false;
		canMove = true;
		impactExplosive = false;
		animate = true;
		priority = 2;
		collideSound = "die";
	}

    /**
     * Class constructor
     */
	public Rock(boolean convertible) {
		super(isDestructible, canMove, spriteName, priority, impactExplosive, animate, false, collideSound, convertible);
        this.loadSprite(spriteName);
	}

    public Rock() {
        this(false);
    }
}