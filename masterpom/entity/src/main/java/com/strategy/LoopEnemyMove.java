package com.strategy;

import com.entity.mobileelements.Enemy;

/**
 * The LoopEnemyMove class.
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 */
public class LoopEnemyMove  extends Strategy<Enemy> {

	/** The enemy concerned by the strategy */
	private Enemy me = null;
	
	/**
	 * The LoopEnemyMove strategy constructor.
	 * @param me the enemy concerned
	 */
	public LoopEnemyMove(Enemy me) {
		this.me = me;
	}
	
	@Override
	public void runStrategy() {
		
		double randomDirection = Math.random();
		randomDirection = randomDirection * 2 +1;
		int randomDirInt = (int) randomDirection;
		
		switch(randomDirInt) {
		case 1:
			me.entityMove(1, 0, 0, 'S');
			break;
		case 2:
			me.entityMove(-1, 0, 0, 'S');
			break;
		}
		
	}

	@Override
	public String returnStrategy() {
		return "LoopEnemyMove";
	}
}
