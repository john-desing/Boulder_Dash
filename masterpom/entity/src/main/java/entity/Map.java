package entity;

import com.collisionshandler.CollisionsHandler;
import com.entity.mobileelements.Diamond;
import com.entity.mobileelements.Enemy;
import com.entity.mobileelements.Player;
import com.entity.mobileelements.Stone;
import com.entity.motionlesselements.Dirt;
import com.entity.motionlesselements.ExitDoor;
import com.entity.motionlesselements.Path;
import com.entity.motionlesselements.Walls;

/**
 * The Map class.
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 */
public class Map extends Entity {

	/** The content of the map */
	private String contentOfMap;
	/** The id of the map */
	private int id;
	/** The bidimensional array containing the entities of the map */
	private Entity[][] mapToChars;
	/** The collisions handler of the map */
	private CollisionsHandler collisionsHandler;
	/** The number of diamonds needed to win the level */
	private int numberOfDiamondsNeeded = 0;


	/**
	 * The Map's constructor.
	 * @param id the id of the map
	 * @param content the content of the map
	 * @param numberOfDiamondsNeeded the number of diamonds need to win the level
	 */
	public Map(final int id, final String content, int numberOfDiamondsNeeded) {
		this.setId(id);
		this.setContentOfMap(content);
		collisionsHandler = new CollisionsHandler();
		this.createMapToChars();
		this.numberOfDiamondsNeeded = numberOfDiamondsNeeded;
	}

	/**
	 * The getCollisionsHandler method.
	 * @return CollisionsHandler the collisions handler of the map
	 */
	public CollisionsHandler getCollisionsHandler() {
		return collisionsHandler;
	}

	/**
	 * The setCollisionsHandler method.
	 * @param collisionsHandler the new collisions handler for the map
	 */
	public void setCollisionsHandler(CollisionsHandler collisionsHandler) {
		this.collisionsHandler = collisionsHandler;
	}

	/**
	 * Instantiates a new basic map.
	 */
	public Map() {
		this(1, "", 0);
	}

	/**
	 * Gets the id of the map.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id of the map.
	 *
	 * @param id the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the content of the map
	 *
	 * @return the content as a String.
	 */
	public String getContentOfMap() {
		return this.contentOfMap;
	}

	/**
	 * Sets the content of the map.
	 *
	 * @param content the new content
	 */
	public void setContentOfMap(final String content) {
		this.contentOfMap = content;
	}

	/**
	 * The getHeightMap method.
	 * @return the height of the map
	 */
	public int getHeightMap() {
		String[] mapFirstLength = getContentOfMap().split("\n");
		return mapFirstLength.length;
	}

	/**
	 * The getWidthMap method.
	 * @return the width of the map
	 */
	public int getWidthMap() {
		String[] mapFirstLength = getContentOfMap().split("\n");
		return mapFirstLength[0].length() - 1;
	}

	/**
	 * The getNumberOfDiamondsNeeded method.
	 * @return the number of diamonds need to win the level
	 */
	public int getNumberOfDiamondsNeeded() {
		return numberOfDiamondsNeeded;
	}

	/**
	 * The setNumberOfDiamondsNeeded method.
	 * @param numberOfDiamondsNeeded the new number of diamonds need to win the level
	 */
	public void setNumberOfDiamondsNeeded(int numberOfDiamondsNeeded) {
		this.numberOfDiamondsNeeded = numberOfDiamondsNeeded;
	}

	/**
	 * The createMapToChars method.
	 * Transform the String content of the map into entities.
	 */
	public void createMapToChars() {
		String map = this.getContentOfMap();
		if (getHeightMap() >= 1 && getWidthMap() >= 1) {
			this.mapToChars = new Entity[this.getWidthMap()][this.getHeightMap()];
			for (int y = 0; y < getHeightMap(); y++) {
				String[] finalMap = map.split("\n");
				for (int x = 0; x < getWidthMap(); x++) {
					switch (finalMap[y].toCharArray()[x]) {
					case 'q':
						mapToChars[x][y] = new Walls(x, y);
						break;
					case 't':
						mapToChars[x][y] = new Dirt(x, y);
						break;
					case 'y':
						mapToChars[x][y] = new Player(x, y);
						break;
					case 'o':
						mapToChars[x][y] = new Stone(x, y);
						break;
					case 'i':
						mapToChars[x][y] = new Enemy(x, y);
						break;
					case 'u':
						mapToChars[x][y] = new Path(x, y);
						break;
					case 'x':
						mapToChars[x][y] = new Diamond(x, y);
						break;
					case 'e':
						mapToChars[x][y] = new ExitDoor(x, y);
						break;
					default:
						break;
					}

					mapToChars[x][y].setMap(this);

				}
			}
		}
	}

	/**
	 * The getArrayMap method.
	 * @return the bidimensional array of the map with all the entities.
	 */
	public Entity[][] getArrayMap() {

		return this.mapToChars;
	}

	/**
	 * The getPlayer method.
	 * @return the player of the map.
	 */
	public Player getPlayer() {
		Entity[][] entity = this.getArrayMap();
		for (int y = 0; y < getHeightMap(); y++) {
			for (int x = 0; x < getWidthMap(); x++) {
				if (entity[x][y] instanceof Player) {
					return (Player) entity[x][y];
				}
			}
		}
		return null;
	}

	/**
	 * The loop method.
	 * Executes methods of the map and its entities.
	 */
	public void loop() {
		Player p = this.getPlayer();
		if(p != null) {
				p.playerDeathLinkToEnemy();
				p.didPlayerWin(numberOfDiamondsNeeded);
				this.runStrategies();
		}
	}
	
	/**
	 * The runStrategies method.
	 * Launch the map's entities strategies.
	 */
	public void runStrategies() {
		Entity[][] entity = this.getArrayMap();
		for (int y = getHeightMap() -1; y >= 0; y--) {
			for (int x = 0; x < getWidthMap(); x++) {
				if(entity[x][y].getStrategy() != null) {
					entity[x][y].getStrategy().runStrategy();
				}
			}
		}
	}

}