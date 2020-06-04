package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
		
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(final Graphics graphics) {
		int Y = 20;
		if(this.getViewFrame().getModel().getTabLine(0,0) == null) {
			viewFrame.setTitle("MENU of game");
			try {
			      Image img = ImageIO.read(getClass().getResource("/images/menu1.png"));
			      graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}else {
			viewFrame.setTitle("Level " + this.getViewFrame().getModel().getLevel() + "                     Number of diamond(s) : "+this.getViewFrame().getModel().getCharacter().getNbDiamond());
			graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
			for(int i = 0; i < 22; i++) {
				for(int j = 0; j < 40; j++) {
					graphics.drawImage(this.getViewFrame().getModel().getMap(i, j), (j*32), Y, this);
				}
				Y += 32;
			}
		}
	}
}
