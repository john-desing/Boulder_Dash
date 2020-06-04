package controller;

import java.awt.Image;
import java.util.ArrayList;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Air;
import entity.Diamond;
import entity.Door;
import entity.Entity;

/**
 * The Class Controller.
 * @author Emannuel KANWE
 * @since 19-05-2020
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;
/**
 * instantiate the new array list with all the threads
 */
	ArrayList<Thread> threadList = new ArrayList<Thread>();

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
	 * Control.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("welcome to BoulderDash Game /n Press 'A', 'Z', 'E', 'R' or 'T' to generate the different levels");
	}

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	public IModel getModel() {
		return this.model;
	}
/**
 * Check if the thread is already launched. If not launched, it launch it.
 */
	private void threadCreation() {
		if (threadList.isEmpty()) {
			BoulderThread thread = new BoulderThread("thread", view, model);
			threadList.add(thread);
			threadList.get(0).start();
		}
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
		case map1:
			this.model.loadMap(1);
			threadCreation();
			break;
		case map2:
			this.model.loadMap(2);
			threadCreation();
			break;
		case map3:
			this.model.loadMap(3);
			threadCreation();
			break;
		case map4:
			this.model.loadMap(4);
			threadCreation();
			break;
		case map5:
			this.model.loadMap(5);
			threadCreation();
			break;
		default:
			break;
		}
	}

	public void movement(int KeyCode) {
		swap(model.getTabEntity(), model.getMap(), KeyCode);
		if (model.getCharacter().getNbDiamond() == 10) {
			Door door = new Door(model.getDoorY(), model.getDoorX());
			model.setTabEntity(model.getDoorY(), model.getDoorX(), door);
			model.setMap(model.getDoorY(), model.getDoorX(), door.getSpritePath());
		}
	}
/**
 * 
 * @param entity
 * 		The entity
 * @return
 * 		return entity.getcanbedestroyed
 */
	private Boolean check(Entity entity) {
		return entity.getCanBeDestroyed();
	}
/**
 * 
 * @param entity
 * 		The entity
 * @return
 * 		Check if there is a Diamond
 */
	private Boolean checkDiamond(Entity entity) {
		if (entity instanceof Diamond) {
			return true;
		} else {
			return false;
		}
	}
/**
 * 
 * @param entity
 * 		The entity
 * @return
 * 		Check if the entity can be pushed
 */
	private Boolean checkPushed(Entity entity) {

		return entity.getCanBePushed();
	}
/**
 * Intervert the player's position with the position of the entity where he wants to go to generate movement.
 * @param tabEntity
 * 		An array of entity
 * @param tabImage
 * 		An array of sprite
 * @param i
 * 		Get the keycode of the key
 */
	public void swap(Entity[][] tabEntity, Image[][] tabImage, int i) {
		Entity entity;
		Image image;
		int y = model.getPosX();
		int x = model.getPosY();
		switch (i) {
		case 38:
			if (check(tabEntity[y - 1][x])) {
				entity = tabEntity[y][x];
				image = tabImage[y][x];
				if (tabEntity[y - 1][x] instanceof Diamond) {
					model.getCharacter().setNbDiamond(model.getCharacter().getNbDiamond() + 1);
				}
				Air air = new Air(x, y);
				tabEntity[y][x] = air;
				tabEntity[y - 1][x] = entity;
				tabImage[y][x] = air.getSpritePath();
				tabImage[y - 1][x] = image;
				model.setPosX(-1);
			}
			if (y == model.getDoorY() && x == model.getDoorX()) {
				int level = model.getLevel();
				if (level == 5) {
					view.printMessage("congratilation you win the last stage");
					view.close();
				} else {
					view.printMessage("You win the level " + level);
					model.loadMap(model.getLevel() + 1);
				}
			}
			break;
		case 40:
			if (check(tabEntity[y + 1][x])) {
				entity = tabEntity[y][x];
				if (checkDiamond(tabEntity[y + 1][x])) {
					model.getCharacter().setNbDiamond(model.getCharacter().getNbDiamond() + 1);
				}
				Air air = new Air(x, y);
				tabEntity[y][x] = air;
				tabEntity[y + 1][x] = entity;
				image = tabImage[y][x];
				tabImage[y][x] = air.getSpritePath();
				tabImage[y + 1][x] = image;
				model.setPosX(1);
			}
			if (y == model.getDoorY() && x == model.getDoorX()) {
				int level = model.getLevel();
				if (level == 5) {
					view.printMessage("congratilation you win the last stage");
					view.close();
				} else {
					view.printMessage("You win the level " + level);
					model.loadMap(model.getLevel() + 1);
				}
			}
			break;
		case 39:
			if (check(tabEntity[y][x + 1])) {
				entity = tabEntity[y][x];
				if (checkDiamond(tabEntity[y][x + 1])) {
					model.getCharacter().setNbDiamond(model.getCharacter().getNbDiamond() + 1);
				}
				Air air = new Air(x, y);
				tabEntity[y][x] = air;
				tabEntity[y][x + 1] = entity;
				image = tabImage[y][x];
				tabImage[y][x] = air.getSpritePath();
				tabImage[y][x + 1] = image;
				model.setPosY(1);
			}
			if (checkPushed(tabEntity[y][x + 1])) {
				entity = tabEntity[y][x + 2];
				tabEntity[y][x + 2] = tabEntity[y][x + 1];
				tabEntity[y][x + 1] = tabEntity[y][x];
				tabEntity[y][x] = entity;
				image = tabImage[y][x + 2];
				tabImage[y][x + 2] = tabImage[y][x + 1];
				tabImage[y][x + 1] = tabImage[y][x];
				tabImage[y][x] = image;
				model.setPosY(1);
			}
			if (y == model.getDoorY() && x == model.getDoorX()) {
				int level = model.getLevel();
				if (level == 5) {
					view.printMessage("congratilation you win the last stage");
					view.close();
				} else {
					view.printMessage("You win the level " + level);
					model.loadMap(model.getLevel() + 1);
				}
			}
			break;
		case 37:
			if (check(tabEntity[y][x - 1])) {
				entity = tabEntity[y][x];
				if (checkDiamond(tabEntity[y][x - 1])) {
					model.getCharacter().setNbDiamond(model.getCharacter().getNbDiamond() + 1);
				}
				Air air = new Air(x, y);
				tabEntity[y][x] = air;
				tabEntity[y][x - 1] = entity;
				image = tabImage[y][x];
				tabImage[y][x] = air.getSpritePath();
				tabImage[y][x - 1] = image;
				model.setPosY(-1);
			}
			if (checkPushed(tabEntity[y][x - 1])) {
				entity = tabEntity[y][x - 2];
				tabEntity[y][x - 2] = tabEntity[y][x - 1];
				tabEntity[y][x - 1] = tabEntity[y][x];
				tabEntity[y][x] = entity;
				image = tabImage[y][x - 2];
				tabImage[y][x - 2] = tabImage[y][x - 1];
				tabImage[y][x - 1] = tabImage[y][x];
				tabImage[y][x] = image;
				model.setPosY(-1);
			}
			if (y == model.getDoorY() && x == model.getDoorX()) {
				int level = model.getLevel();
				if (level == 5) {
					view.printMessage("congratilation you win the last stage");
					view.close();
				} else {
					view.printMessage("You win the level " + level);
					model.loadMap(model.getLevel() + 1);
				}
			}
			break;
		default:
			break;
		}
		model.update();
	}
}