package com.strategy;

import com.entity.mobileelements.Enemy;

/**
 * The RandomEnemyMove class.
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 */
public class RandomEnemyMove extends Strategy<Enemy> {

	/** The enemy concerned by the strategy */
	private Enemy me = null;
	
	/**
	 * The RandomEnemyMove strategy constructor.
	 * @param me the enemy concerned
	 */
	public RandomEnemyMove(Enemy me) {
		this.me = me;
	}

	@Override
	public void runStrategy() {
		
		if(me.getIsAlive()) {
			double randomDirection = Math.random();
			randomDirection = randomDirection * 4 +1;
			int randomDirInt = (int) randomDirection;
			switch(randomDirInt) {
			case 1:
				me.entityMove(0, -1, 0, 'S');
				break;
			case 2:
				me.entityMove(-1, 0, 0, 'S');
				break;
			case 3:
				me.entityMove(0, 1, 0, 'S');
				break;
			case 4:
				me.entityMove(+1, 0, 0, 'S');
				break;
			}
		} else {
			me.loadImage('X', me);
		}
		
		
		
	}

	@Override
	public String returnStrategy() {
		return "RandomEnemyMove";
	}

}
