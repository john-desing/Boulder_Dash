package controller;

import java.awt.Image;

import contract.IModel;
import contract.IView;
import entity.Air;
import entity.Boulder;
import entity.Diamond;
import entity.Entity;
import entity.Character;

	/**
	 * 
	 *  @author Emannuel KANWE
       * @since 20-05-2020
	 *
	 */

public class BoulderThread extends Thread {
	/** The View */
	IView view;
	/** The Model */
	IModel model;

	/** Contains the position X and Y of the Boulder */
	int[][] tabBoulder = new int[2][210];
	/** The Entity Array */
	Entity[][] tabEntity;
	/** The Sprite Array */
	Image[][] tabMap;

	/** The Boulder */
	Boulder boulder;
	/** The Diamond */
	Diamond diamond;

	/**
	 * Instantiates a new BoulderThread
	 * 
	 * @param name  The name of the Thread
	 * @param view  The View
	 * @param model The Model
	 */
	public BoulderThread(String name, IView view, IModel model) {
		super(name);
		this.view = view;
		this.model = model;
	}

	/**
	 * Automatically executed at the beginning of the Thread, Execute the function
	 * fall() every 100 Ms
	 */
	public void run() {
		while (true)
			try {
				this.fall();
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * Swap is used to make boulders falls
	 * 
	 * @param i The boulder's X position before the swap
	 * @param j The boulder's Y position before the swap
	 */
	public void swap(int i, int j) {
		Entity entity;
		entity = tabEntity[j][i];
		tabEntity[j][i] = tabEntity[j + 1][i];
		tabEntity[j + 1][i] = entity;
		Image image;
		image = tabMap[j][i];
		tabMap[j][i] = tabMap[j + 1][i];
		tabMap[j + 1][i] = image;
		model.update();
	}

	/**
	 * Load the position X and Y of all the boulders in the TabEntity
	 * 
	 * @return An array with all the boulders' X and Y position
	 */
	public int[][] definition() {
		this.tabEntity = model.getTabEntity();
		this.tabMap = model.getMap();
		int k = 0;
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 40; j++) {
				if (tabEntity[i][j] instanceof Boulder || tabEntity[i][j] instanceof Diamond) {
					tabBoulder[0][k] = j;
					tabBoulder[1][k] = i;
					k++;
					tabEntity[i][j].setFalling(false);
					tabEntity[i][j].setCanBePushed(false);
				}
			}
		}
		return tabBoulder;
	}

	/**
	 * Check if the Boulders/Dimaonds can fall, if the player is under the boulder
	 * or diamond, if the boulder can be pushed and reload the Level if the player
	 * dies.
	 */
	public void fall() {
		tabBoulder = definition();
		int j = 0;
		for (j = 0; j < 210; j++) {
			if (tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]] instanceof Air
					|| tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]] instanceof Character) {
				if (tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]] instanceof Air) {
					swap(tabBoulder[0][j], tabBoulder[1][j]);
					tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]].setFalling(true);
					if (tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]].getFalling()
							&& tabEntity[tabBoulder[1][j] + 2][tabBoulder[0][j]] instanceof Character) {
						view.printMessage("              Game Over\n                Try Again");
						model.loadMap(model.getLevel());
					}
				}
			}
			if (tabBoulder[0][j] != 0 && tabEntity[tabBoulder[1][j]][tabBoulder[0][j]] instanceof Boulder) {
				if (tabEntity[tabBoulder[1][j]][tabBoulder[0][j] - 1] instanceof Air
						|| tabEntity[tabBoulder[1][j]][tabBoulder[0][j] + 1] instanceof Air) {
					tabEntity[tabBoulder[1][j]][tabBoulder[0][j]].setCanBePushed(true);
				}
			}
		}
	}
}