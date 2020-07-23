package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.entity.mobileelements.Player;

import contract.IModel;
import entity.Entity;
import entity.Map;
import entity.Sprite;

/**
 * The ViewPanel class.
 *
 * @author fruissala KANWER
 * @version 1.0
 */
@SuppressWarnings("unused")
public
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;
	/** The counter until the end of the game */
	private static int counter = 200;
	/** The boolean to refresh some information only once */
	private boolean hasBeenNotifiedToStop = false;
	/** The boolean to start properly the timer */
	private boolean isTimerStart = false;

	public ViewPanel() {
	}

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		viewFrame.getModel().getMap();

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
	 * @param viewFrame the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	/**
	 * Repaint the view.
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */

	/**
	 * Display information on screen. Method called each time the view is "painted".
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {

		final double scale = 3.0;
		final int imageSize = 16;
		final int width = this.getWidth();
		final int height = this.getHeight();
		final int timerResetValue = 200;
		Map map = this.viewFrame.getModel().getMap();
		Entity[][] loadMap = null;
		Player player = null;
//		a = getWidth();
//		b = getHeight();
		if (map.getPlayer() != null) {

			loadMap = map.getArrayMap();
			player = this.viewFrame.getModel().getMap().getPlayer();
			int playerPosX = this.viewFrame.getModel().getMap().getPlayer().getPositionX();
			int playerPosY = this.viewFrame.getModel().getMap().getPlayer().getPositionY();
			Font font = new Font("Goudy Stout", Font.BOLD, 20);
			graphics.setFont(font);
			if (counter != 0 && counter != -100) {

				this.focusMapOnPlayer(graphics, width, height, playerPosX, playerPosY, scale, imageSize);

				this.displayMap(graphics, width, height);
				
				if (isTimerStart == false) {
					ViewPanel.startTimer();
					this.isTimerStart = true;
				}

				this.reverseFocusOnScreenAndStats(graphics, scale, width, height, playerPosX, playerPosY, player, map, imageSize);

			} else {
				graphics.clearRect(0, 0, width, height);
				graphics.drawString("BAD TIMING !", width / 2 - 75, height / 2);
				counter = -100;
				/*
				 * NOW WE HAVE TO PERFORM AN ACTION WHEN THE PLAYER LOOSES (+ RESTART THE TIMER
				 * = set it two 200 when the player switch between the maps)
				 */
			}
			

		} else {
			//graphics.clearRect(0, 0, width, height);
			Sprite sprite = new Sprite('0', "menu.png");
			try {
			      sprite.loadImage();
			      graphics.drawImage(sprite.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}
	}

	/**
	 * The startTimer method.
	 * Launch a specific timer, calculated by seconds.
	 * 
	 */
	public static void startTimer() { // This is a timer
		ViewPanel drawTimer = new ViewPanel();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (counter != -100 && counter > 0) {
					counter--;// increments the counter
				}
			}
		};
		Timer timer = new Timer("MyTimer"); 
		timer.scheduleAtFixedRate(timerTask, 1000, 1000); 
	}

	/**
	 * The displayMap method.
	 * Allows the paintComponent method to display the map and its entities.
	 * @param graphics the Graphics
	 * @param width the width of the view
	 * @param height the height of the view
	 */
	public void displayMap(Graphics graphics, int width, int height) {

		final int imageSize = 16;
		final int numberOfLevels = 7;
		Map map = this.viewFrame.getModel().getMap();
		IModel getModel = this.viewFrame.getModel();
		Entity[][] loadMap = map.getArrayMap();
		Player player = this.viewFrame.getModel().getMap().getPlayer();
		final int timerResetValue = 200;
		for (int x = 0; x < map.getWidthMap(); x++) {
			for (int y = 0; y < map.getHeightMap(); y++) {
				graphics.drawImage(loadMap[x][y].getSprite().getImage(), x * imageSize, y * imageSize, this);
			}
		}
	
		if (!player.getIsAlive()&& hasBeenNotifiedToStop == false) {

			hasBeenNotifiedToStop = true;
			graphics.clearRect(0, 0, width, height);
			this.viewFrame.printMessage("You died ! Try again...");
			getModel.loadMap(map.getId());
			hasBeenNotifiedToStop = false;
		}

		if (player.getIsWin() && hasBeenNotifiedToStop == false) {
			if (map.getId() < numberOfLevels) {
				getModel.loadMap(map.getId() + 1);
				counter = timerResetValue;
			} else {
				hasBeenNotifiedToStop = true;
				player.setIsAlive(false);
				graphics.clearRect(0, 0, width, height);
				this.viewFrame.printMessage("You won ! Congrats !");
				System.exit(0);
			}
		}
	}

	/**
	 * The focusMapOnPlayer method.
	 * Zoom and center the attention on the player.
	 * @param graphics the Graphics
	 * @param width the width of the view
	 * @param height the height of the view
	 * @param playerPosX the x coord of the player
	 * @param playerPosY the y coord of the player
	 * @param scale the zoom used to focus on player
	 * @param imageSize the sprite size
	 */
	public void focusMapOnPlayer(Graphics graphics, int width, int height, int playerPosX, int playerPosY, double scale, int imageSize) {

		graphics.clearRect(0, 0, width, height);
			graphics.translate(0,
					(int) (-playerPosY * imageSize + 10));
			((Graphics2D) graphics).scale(2, 2);
	}

	/**
	 * The reverseFocusOnScreenAndStats method.
	 * Displays statistics on the right upper corner of the view.
	 * @param graphics the Graphics
	 * @param scale the zoom used to focus on the player
	 * @param width the width of the view
	 * @param height the height of the view
	 * @param playerPosX the x coord of the player
	 * @param playerPosY the y coord of the player
	 * @param player the player
	 * @param map the map
	 * @param imageSize the sprite size
	 */
	public void reverseFocusOnScreenAndStats(Graphics graphics, double scale, int width, int height, int playerPosX,
			int playerPosY, Player player, Map map, int imageSize) {

		final int xStartStatsValues = width + 30;
		final int yStartStatsValues = 0;
		final int xEndStatsValues = 240;
		final int yEndStatsValues = 65;
		final int xStartStatsDisplay = width + 30;
		graphics.setColor(Color.white);
		graphics.fillRect(588, 290,120, 50);
		 Font font = new Font("Courier", Font.BOLD, 8);
		 graphics.setFont(font);
		graphics.setColor(Color.BLUE);
		graphics.drawString("Remaining time : " + counter, 590, 315);
		//graphics.drawString(String.valueOf("Diamond Counter : " + player.getDiamondsCounter()), 590, 350);
		graphics.setColor(Color.RED);
		graphics.drawString(String.valueOf("Number needed : " + map.getNumberOfDiamondsNeeded()), 590,
				330);

		if (player.getDiamondsCounter() >= map.getNumberOfDiamondsNeeded()) {
			graphics.setColor(Color.white);
			graphics.fillRect(588, 290,120, 50);
			graphics.setColor(Color.BLUE);
			graphics.drawString("Remaining time : " + counter, 590, 315);
			graphics.setColor(Color.RED);
			//graphics.drawString(String.valueOf("Number needed : " + map.getNumberOfDiamondsNeeded()), 590,
					//330);
			//graphics.clearRect(650, 0,120, 100);
			//graphics.setColor(Color.BLACK);
			//graphics.drawString("Remaining time : " + counter, 590, 310);
			graphics.setColor(Color.GREEN);
			graphics.drawString(String.valueOf("Diamond Counter : " + player.getDiamondsCounter()), 590, 300);
			//graphics.setColor(Color.BLUE);
			graphics.drawString("GO TO EXIT DOOR !", 590, 330);
		}
		else {
			graphics.setColor(Color.YELLOW);
			graphics.drawString(String.valueOf("Diamond Counter : " + player.getDiamondsCounter()), 590, 300);
		}

	}
	
	
	 
    /**
     * The getCounter method.
     * @return the counter
     */
    public int getCounter() {
      return counter;
    }

    
    /**
     * The setCounter method.
     * @param newCounter the new counter
     * @throws IndexOutOfBoundsException in case of an exception
     */
    public void setCounter(int newCounter) throws IndexOutOfBoundsException{
      if (newCounter > 0 && newCounter < 10000) {
          ViewPanel.counter = newCounter;
      }else {
          throw new IndexOutOfBoundsException("Wrong parameters");
      }
    }

}
