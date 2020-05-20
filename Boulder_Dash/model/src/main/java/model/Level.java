package model;

public class Level extends DisplayableElementModel {

	public Level(boolean destructible, boolean moving, String spriteName, int priority, boolean impactExplosive,
			boolean animate, boolean falling, String collideSound, boolean convertible) {
		super(destructible, moving, spriteName, priority, impactExplosive, animate, falling, collideSound, convertible);
		// TODO Auto-generated constructor stub
	}

	public Level(boolean destructible, boolean moving, String spriteName, int priority, boolean impactExplosive,
			boolean animate, boolean falling, String collideSound) {
		super(destructible, moving, spriteName, priority, impactExplosive, animate, falling, collideSound);
		// TODO Auto-generated constructor stub
	}

}
