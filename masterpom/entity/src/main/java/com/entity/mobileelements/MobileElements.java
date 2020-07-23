package com.entity.mobileelements;

import java.io.IOException;

import com.collisionshandler.CollisionsHandler;
import com.entity.motionlesselements.Path;

import entity.Entity;
import entity.Sprite;

/**
 * The Abstract Class MobileElements.
 *
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
*/

public abstract class MobileElements extends Entity {
	
	/** The diamond counter */
	private int diamondsCounter;
	
	/** The boolean to indicates if the mobile element is alive */
	protected boolean isAlive;
	
	/** The death sprite for mobile entities */
	protected static final Sprite spriteDeath = new Sprite('y', "Death.png");
	
	
	/**
	 * The MobileElements constructor
	 * @param sprite the default sprite of the entity
	 * @param x the initial entity's x on the map
	 * @param y the initial entity's y on the map
	 */
	
	public MobileElements(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	/**
	 * The entityMove method.
	 * Allows mobile entities to move on the map.
	 * @param x the x the entity wants to go (1 goes for right and -1 for left)
	 * @param y the y the entity wants to go (1 goes for down and -1 for up)
	 * @param sideX the side the entity wants to move a stone
	 * @param direction the char that indicates to load the entity's specific sprite
	 */
	
	public void entityMove(int x, int y, int sideX, char direction) {

		final int xpos = this.getPositionX();
		final int ypos = this.getPositionY();
		final Entity[][] loadArrayMap = this.getMap().getArrayMap();
		final Player player = this.getMap().getPlayer();
		final CollisionsHandler getCollisionHandler = this.getMap().getCollisionsHandler();
		boolean collision = false;
		boolean isDiamond = false;
		boolean moveStone = false;
		boolean isPlayer = false;
		
			if(this instanceof Player) {
				collision = getCollisionHandler.checkForCollisions(loadArrayMap,xpos + x, ypos + y);
				isDiamond = getCollisionHandler.checkForDiamonds(loadArrayMap, xpos + x,ypos + y);
				moveStone = getCollisionHandler.checkForStoneToMove(loadArrayMap, xpos + x, ypos + y, sideX);
			}else {
				collision = getCollisionHandler.checkForPath(loadArrayMap,xpos + x, ypos + y);
				isPlayer = getCollisionHandler.checkForPlayer(loadArrayMap, xpos + x, ypos + y);
			}
				

			this.loadImage(direction, this);
			
			if(moveStone) {
				loadArrayMap[xpos + x + sideX][ypos + y] = loadArrayMap[xpos + x][ypos + y];
				loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
				loadArrayMap[xpos][ypos] = new Path(xpos, ypos);
				this.setPositionY(ypos + y);
				this.setPositionX(xpos + x);
				loadArrayMap[xpos + x + sideX][ypos + y].setPositionX(xpos + x + sideX);
			}
			
			if (!collision) {

				if(isPlayer == true) {
					player.setIsAlive(false);
				} else {
					loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
					loadArrayMap[xpos][ypos] = new Path(xpos, ypos);
					this.setPositionY(ypos + y);
					this.setPositionX(xpos + x);
				}
				
			}

			if (isDiamond == true) {
				this.incrementDiamondsCounter();
			}
			

			
	}

	/**
	 * The loadImage method.
	 * Allows the entity to change sprite on the map depending on its movements.
	 * @param direction the direction of the entity
	 * @param entity the entity
	 */
	
	public void loadImage(char direction, Entity entity) {

		switch (direction) {

		case 'Z':
			entity.setSprite(entity.getSpriteUp());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'S':
			entity.setSprite(entity.getSpriteDown());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'Q':
			entity.setSprite(entity.getSpriteTurnLeft());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'D':
			entity.setSprite(entity.getSpriteTurnRight());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'X':
			entity.setSprite(entity.getSpriteDeath());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	/**
	 * The incrementDiamondsCounter method.
	 * Increase by 1 the diamond counter of the entity.
	 */
	public void incrementDiamondsCounter() {
		this.diamondsCounter++;
	}
	
	/**
	 * The increaseDiamondsCounter method.
	 * @param increase the amount of increase of the counter.
	 */
	
	public void increaseDiamondsCounter(int increase) {
		this.diamondsCounter += increase;
	}

	/**
	 * The getDiamondsCounter methods.
	 * @return the number of diamonds the entity has
	 */
	
	public int getDiamondsCounter() {
		return this.diamondsCounter;
	}

	/**
	 * The getIsAlive method.
	 * @return the status of live of the entity (true = is living).
	 */
	public boolean getIsAlive() {
		return this.isAlive;
	}

	/**
	 * The setIsAlive method.
	 * @param isAlive define if the entity is still alive or not
	 */
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	/**
	 * The getSpriteDeath method.
	 * @return the death sprite of mobile entities
	 */
	public Sprite getSpriteDeath() {
		return MobileElements.spriteDeath;
	}

}
