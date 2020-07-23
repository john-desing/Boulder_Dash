package com.collisionshandler;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entity.mobileelements.Enemy;
import com.entity.mobileelements.Player;
import com.entity.mobileelements.Stone;

import entity.Map;

/**
 * The CollisionsHandlerTest method.
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 */
public class CollisionsHandlerTest {
	
	/** The map to test collisions. */
	private Map map;
	/** The x of the entity on the map */
	private int x;
	/** The y of the entity on the map */
	private int y;
	/** The mobile element concerned by the strategy */
	private Player p;
	/** The player on the map */
	@SuppressWarnings("unused")
	/** The enemy on the map */
	private Enemy e;
	/** The stone on the map */
	private Stone s;
	/** The stone to move on the map */
	private Stone sForMove;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * The setUp method.
	 * Load the map and entities.
	 * @throws Exception in case of an exception
	 */
	@Before
	public void setUp() throws Exception {
		this.map = new Map(1 , "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" + 
				"qtttootttttttttttttqtttttttttttttttttttq\r\n" + 
				"qtttuttttttttttttttqtotttoottttttttxtttq\r\n" + 
				"qtttuuuttttttttttttqtttttttttttttttttttq\r\n" + 
				"qttttttttoooootttttqttttuuiutttotttttttq\r\n" + 
				"qttttttttutttttttttqtttttttttttoottttttq\r\n" + 
				"qttttttttuuuiutttttqtttttttttttoottttttq\r\n" + 
				"qqqqqqqqttttqqqqqqqqqqqqqqqquuttqqqqqqqq\r\n" + 
				"qttttttttttttttttttqtttttttttttttttttttq\r\n" + 
				"qtttuuuttttttttttttqttttttttuttttttttttq\r\n" + 
				"qttttttttxttottttttqtttttttttttttttotttq\r\n" + 
				"qtootttttttouttttttqtttttutttutttttotttq\r\n" + 
				"qttottttttttuttttttotttttttttxttttotottq\r\n" + 
				"qtttottttuttuttttttttttttttttttttttotteq\r\n" + 
				"qttxxttttuuttttotttutttttttttttttttttttq\r\n" + 
				"qttttttttttttttotttqttttottttttttttttttq\r\n" + 
				"qttttttttttttttotttqttttootttttuuttttttq\r\n" + 
				"qtttuuutttttttootttqttttotttttttottttttq\r\n" + 
				"qttttttttttttttttttqtttoootttttttttttttq\r\n" + 
				"qqqqqqqqttttqqqqqqqqqqqqqqqqttxtqqqqqqqq\r\n" + 
				"qtttttottttttttttutqtttttttttttttutttttq\r\n" + 
				"qttttxotttttttttuttqttxttttttttttitttttq\r\n" + 
				"qttttttttttttttttttqtttttttttttttutttttq\r\n" + 
				"qtttttttttutttottttqtttttttttttttttttotq\r\n" + 
				"qttuttttttttttotttuoutttttttttttttttttoq\r\n" + 
				"qtttttttttttttottttotttttttttotttttttxtq\r\n" + 
				"qtttttxuutttttttttttttttttttootttttttttq\r\n" + 
				"qttttttttttttttttttqttttttttootttttttttq\r\n" + 
				"qtttttttttutttttottqtuiutttttttttttttttq\r\n" + 
				"qtttttttttuttttttotqttxttttttttttttttttq\r\n" + 
				"qttttttttttttttttttqtttttttttttttttttttq\r\n" + 
				"qqqqqqqqttooqqqqqqqqqqqqqqqqttttqqqqqqqq\r\n" + 
				"qttttttttttttttttttqtttttttttttotttttttq\r\n" + 
				"qttttttuotttttootttqttttttttttttttottttq\r\n" + 
				"qttutttttttttttttttqutttttuttttutttotttq\r\n" + 
				"qttyouuttttttxtttutqottotttttttutttttttq\r\n" + 
				"qttuutttttttttttuutqottttttotttutttttttq\r\n" + 
				"qttttttttttttttttttqxxtttttttttttttttttq\r\n" + 
				"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", 10);
		map.createMapToChars();
		this.e = new Enemy(x+1,y);
		this.p = this.map.getPlayer();
		this.x = this.p.getPositionX();
		this.y = this.p.getPositionY();
		this.s = (Stone) map.getArrayMap()[4][1];
		this.sForMove = (Stone)map.getArrayMap()[4][35];
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testCollision method.
	 * Moves the player against a stone and verify its coords. If there is a collision, coords don't change.
	 * 
	 */
	@Test
	public void testCollision() {

		final int expectedX = 3;
		final int expectedY = 35;
		
		
		p.entityMove(1, 0, 0, 'S');
		assertEquals(expectedX, x);
		assertEquals(expectedY, y);

	}
	
	/**
	 * The testGravity method.
	 * Makes a stone fall and checks its coords.
	 * 
	 */
	@Test
	public void testGravity() {
		
		final int expectedYBeforeGravity = 1;
		assertEquals(expectedYBeforeGravity, s.getPositionY());

		final int expectedYAfterGravity = 3;
		
		
		for (int i=0;i<3;i++) {
            map.runStrategies();
        }
		assertEquals(expectedYAfterGravity, s.getPositionY());

	}
	
	/**
	 * The testMoveStone method.
	 * Makes the player moving a stone and checks the latter coords.
	 */
	@Test
	public void testMoveStone() {
		
		p.entityMove(1, 0, 1, 'S');
		
		final int expectedStoneXAfterMove = 5;
		
		assertEquals(expectedStoneXAfterMove, sForMove.getPositionX());

	}
	
	
	
	
}