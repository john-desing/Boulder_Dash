package com.strategy;

import com.entity.mobileelements.Enemy;
import com.entity.mobileelements.MobileElements;
import com.entity.mobileelements.Player;
import com.entity.motionlesselements.Path;

import entity.Entity;


/**
 * The BasicFalling class.
 * Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 */
public class BasicFalling extends Strategy<MobileElements> {

	
	/**
	 * The BasicFalling strategy constructor
	 * @param me the mobile element concerned
	 */
	public BasicFalling(MobileElements me) {
		this.me = me;
	}
	
	
	@Override
	public void runStrategy() {
		
		Entity getNextEntity = me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()+1];
		final int bonusEnemyKilled = 4;
		
		if (getNextEntity instanceof Path) {
			me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()+1] = me;
			me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()] = new Path(me.getPositionX(), me.getPositionY());
			me.setIsFallen(true);
			me.setPositionY(me.getPositionY()+1);
		} else if (getNextEntity instanceof Player && me.getIsFallen()){
			((Player)getNextEntity).setIsAlive(false);
			
		} else if(getNextEntity instanceof Enemy && me.getIsFallen()) {
			
			((Enemy)getNextEntity).setIsAlive(false);
			me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()+1] = new Path(me.getPositionX(), me.getPositionY());
			me.getMap().getPlayer().increaseDiamondsCounter(bonusEnemyKilled);
		} else {
			me.setIsFallen(false);
		}
	}
	
	@Override
	public String returnStrategy() {
		return "BasicFalling";
	}
}
