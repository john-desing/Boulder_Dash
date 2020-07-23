package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The View class.
 *
 * @author Fruissala KANWER
 * @version 1.0
 */
public final class View implements IView, Runnable {

	/** The frame. */
	private ViewFrame viewFrame = null;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	
	public View() {
		
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code 
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return ControllerOrder.Z;	
			case KeyEvent.VK_LEFT:
				return ControllerOrder.Q;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.S;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.D;
			case KeyEvent.VK_1:
				return ControllerOrder.Map1;
			case KeyEvent.VK_2:
				return ControllerOrder.Map2;
			case KeyEvent.VK_3:
				return ControllerOrder.Map3;
			case KeyEvent.VK_4:
				return ControllerOrder.Map4;
			case KeyEvent.VK_5:
				return ControllerOrder.Map5;
			case KeyEvent.VK_6:
				return ControllerOrder.Map6;
			case KeyEvent.VK_7:
				return ControllerOrder.Map7;	
			default:
				return ControllerOrder.nothing;
		}
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
			this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
