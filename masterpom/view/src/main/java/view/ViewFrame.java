package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;
import entity.Entity;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener {

	Entity entity;
	/** The model. */
	private IModel model;

	/** The controller. */
	private IController controller;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model the model
	 * 
	 */
	public ViewFrame(final IModel model) {
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(41 * 32 + this.getInsets().left + this.getInsets().right,
				24 * 32 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Prints the message.
	 *
	 * @param message the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.getController().movement(e.getKeyCode());
			break;
		case KeyEvent.VK_DOWN:
			this.getController().movement(e.getKeyCode());
			break;
		case KeyEvent.VK_RIGHT:
			this.getController().movement(e.getKeyCode());
			break;
		case KeyEvent.VK_LEFT:
			this.getController().movement(e.getKeyCode());
			break;
		case KeyEvent.VK_A:
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		case KeyEvent.VK_Z:
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		case KeyEvent.VK_E:
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		case KeyEvent.VK_R:
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		case KeyEvent.VK_T:
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		default:
			break;
		}
	}
}
