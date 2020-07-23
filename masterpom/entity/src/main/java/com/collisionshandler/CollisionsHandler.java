package com.collisionshandler;

import com.entity.mobileelements.Diamond;
import com.entity.mobileelements.Enemy;
import com.entity.mobileelements.Player;
import com.entity.mobileelements.Stone;
import com.entity.motionlesselements.ExitDoor;
import com.entity.motionlesselements.Path;
import com.entity.motionlesselements.Walls;

import entity.Entity;

/**
 * The CollisionsHandler Class.
 *
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 */

public class CollisionsHandler {


	/**
	 * CollisionsHandler constructor.
	 * No specific manipulations.
	 */
	public CollisionsHandler() {

	}

	/**
	 * The checkForCollisions method.
	 * @param entity the bidimensional array that contains the entity
	 * @param x the entity's x 
	 * @param y the entity's y
	 * @return a boolean that indicates if there is a collision or not.
	 */
	
	public boolean checkForCollisions(Entity[][] entity, int x, int y) {
		if (entity[x][y] instanceof Stone) {
			return true;
		} else if (entity[x][y] instanceof Walls) {
			return true;
		} else if (entity[x][y] instanceof ExitDoor) {
			return true;
		} else if (entity[x][y] instanceof Enemy) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The checkForDiamonds method.
	 * @param playerPosition the player
	 * @param x the player's x
	 * @param y the player's y
	 * @return a boolean that indicates if the player is going on a diamond.
	 */
	
	public boolean checkForDiamonds(Entity[][] playerPosition, int x, int y) {

		if (playerPosition[x][y] instanceof Diamond) {
			return true;
		}
		return false;
	}
	
	/**
	 * The checkForPlayer method.
	 * @param entity the entity that is gonna kill or no the player
	 * @param x the entity's x
	 * @param y the entity's y
	 * @return a boolean that indicates if there is a player near the entity.
	 */
	
	public boolean checkForPlayer(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Player) {
			return true;
		}
		return false;
	}
	
	/**
	 * The checkForPath method.
	 * @param entity the entity
	 * @param x the entity's x
	 * @param y the entity's y
	 * @return a boolean that indicates if there is a path near the entity. If true, it can moves.
	 */
	
	public boolean checkForPath(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Path) {
			return false;
		}
		return true;
	}
	
	/**
	 * The checkForStoneToMove method.
	 * @param entity the player
	 * @param x the player's x
	 * @param y the player's y
	 * @param sideX the side on which the player wants to move the stone (left/right)
	 * @return a boolean that indicates if the player can move a stone on the side he wants.
	 */
	
	public boolean checkForStoneToMove(Entity[][] entity, int x, int y, int sideX) { 

		if (entity[x][y] instanceof Stone && entity[x+sideX][y] instanceof Path) {
			return true;
		}
		return false;
	}

}