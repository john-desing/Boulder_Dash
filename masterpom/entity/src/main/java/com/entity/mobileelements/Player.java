package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.ExitDoor;
import com.entity.motionlesselements.Path;

import entity.Sprite;

/**
 * The Player class.
 *
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 */

public class Player extends MobileElements {

	/** The basic sprite for the player */
	private static final Sprite spriteDown = new Sprite('y', "Rockford.png");
	/** The left sprite for the player */
	private static final Sprite spriteTurnLeft = new Sprite('y', "Left_Rockford.png");
	/** The right sprite for the player */
	private static final Sprite spriteTurnRight = new Sprite('y', "Right_Rockford.png");
	/** The up sprite for the player */
	private static final Sprite spriteUp = new Sprite('y', "Back_Rockford1.png");
	/** The boolean that indicates if the player won */
	private boolean isWin;

	static {
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The player's constructor
	 * @param x the initial player's x
	 * @param y the initial player's y
	 */
	public Player(int x, int y) {
		super(spriteDown, x, y);
		this.isAlive = true;
		this.isWin = false;

	}

	/**
	 * The getSpriteDown method.
	 * @return Sprite the basic sprite of the player
	 */
	public Sprite getSpriteDown() {
		return spriteDown;
	}
	
	/**
	 * The getSpriteTurnLeft method.
	 * @return Sprite the left sprite of the player
	 */
	public Sprite getSpriteTurnLeft() {
		return spriteTurnLeft;
	}

	/**
	 * The getSpriteTurnRight method.
	 * @return Sprite the right sprite of the player
	 */
	public Sprite getSpriteTurnRight() {
		return spriteTurnRight;
	}

	/**
	 * The getSpriteUp method.
	 * @return Sprite the up sprite of the player
	 */
	public Sprite getSpriteUp() {
		return spriteUp;
	}

	/**
	 * The movePlayer method.
	 * Calls the MobileElements entityMove method.
	 * @param direction the direction the player wants to move, depending on the keyListener in the view
	 */
	public void movePlayer(char direction) {

		if(this.getIsAlive()) {
			switch (direction) {

			case 'Z':
				this.entityMove(0, -1, 0, direction);
				break;
			case 'Q':
				this.entityMove(-1, 0, -1, direction);
				break;
			case 'S':
				this.entityMove(0, +1, 0, direction);
				break;
			case 'D':
				this.entityMove(+1, 0, 1, direction);
				break;
			}
		}
	}
	
	/**
	 * The getIsWin method.
	 * @return a boolean that indicates if the player won
	 */
	public boolean getIsWin() {
		return isWin;
	}

	/**
	 * The setIsWin method.
	 * @param isWin set the win of the player
	 */
	public void setIsWin(boolean isWin) {
		this.isWin = isWin;
	}


	/**
	 * The playerDeathLinkToEnemy method.
	 * Check for any enemy around the player, to kill him if there is some.
	 */
	public void playerDeathLinkToEnemy() {
		
		int x = this.getPositionX();
		int y = this.getPositionY();
		
		if(this.getMap().getArrayMap()[x+1][y] instanceof Enemy ||
				this.getMap().getArrayMap()[x-1][y] instanceof Enemy ||
				this.getMap().getArrayMap()[x][y+1] instanceof Enemy ||
				this.getMap().getArrayMap()[x][y-1] instanceof Enemy) {
			this.setIsAlive(false);
			this.loadImage('X', this);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	/**
	 * The didPlayerWin method.
	 * @param numberOfDiamondsNeeded the number of diamonds necessary to go the next level, stored in the database
	 */
	public void didPlayerWin(int numberOfDiamondsNeeded) {
		
		this.goToExit(0, 1, numberOfDiamondsNeeded);
		this.goToExit(0, -1, numberOfDiamondsNeeded);
		this.goToExit(1, 0, numberOfDiamondsNeeded);
		this.goToExit(-1, 0, numberOfDiamondsNeeded);
		
	}
	
	/**
	 * The goToExit method.
	 * Check if the player goes on an exitDoor.
	 * @param sideX the x side on which the player moves
	 * @param sideY the y side on which the player moves
	 * @param numberOfDiamondsNeeded the number of diamonds necessary to go the next level, stored in the database
	 */ 
	public void goToExit(int sideX, int sideY, int numberOfDiamondsNeeded) {
		
		int x = this.getPositionX();
		int y = this.getPositionY();

		if(this.getMap().getArrayMap()[x+sideX][y+sideY] instanceof ExitDoor && this.getDiamondsCounter() >= numberOfDiamondsNeeded) {
			this.getMap().getArrayMap()[x+sideX][y+sideY] = this.getMap().getArrayMap()[x][y];
			this.getMap().getArrayMap()[x][y] = new Path(x,y);
			this.setIsWin(true);
		}
	}
	
	
}