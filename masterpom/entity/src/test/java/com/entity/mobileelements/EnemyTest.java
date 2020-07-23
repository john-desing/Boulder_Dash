package com.entity.mobileelements;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.strategy.RandomEnemyMove;

import entity.EntityTest;
import entity.Map;

/**
 * The Enemy test class.
 * @author Fruissala KANWER
 * @version 1.0
 *
 */
public class EnemyTest extends EntityTest {
	
	/** The map of the enemy */
	Map map;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Enemy(5,5);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates the map and the enemy.
	 */
	@Before
	public void setUp() throws Exception {
		
		this.map = new Map(233,"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" +
                "qttttttuoutttttttttttttttttttttttttttttq\r\n" +
                "qtttttttoqtttttoootttttttttuuttttqqttttq\r\n" +
                "qtttttttxqtoottttttqtttttttttttttttqtttq\r\n" +
                "qttttttttqttttttttqttttttttttttttttttttq\r\n" +
                "qtttuttttttttttttqttttttttqttttutttttttq\r\n" +
                "qtttuttttqttttttttttttttttxtttttttttqqtq\r\n" +
                "qttttttttqtttutttttttttuottttttttttttttq\r\n" +
                "qttttttttxtttutttttttttuqqqqqqtttttttttq\r\n" +
                "qttttttttqttttttttotttttttttttttttootttq\r\n" +
                "qttttxtttttttttttttottttttttttttttxotttq\r\n" +
                "qtttqqtttutttttqtttootttttttqttttttttttq\r\n" +
                "qttttqtttttttttttttttotttqttqttttttttttq\r\n" +
                "qtttttttttttttttttttttttttttqttttttttttq\r\n" +
                "qttttttttttqqtttttttoutttttttttttttttttq\r\n" +
                "qtootttttttttttttttqqittttutttttttqttttq\r\n" +
                "qttttqttttttttttttttquttttuttttttttttttq\r\n" +
                "qtttttqttttttttttttttttttttttttttttttttq\r\n" +
                "qttttttttttuutttttqtttttttqttttttttotttq\r\n" +
                "qttttttttttttttttqtqtttttttttttttttotttq\r\n" +
                "qttyttttttttttttxxxttxttttttqqtttttxtttq\r\n" +
                "qtttttttttttttttuuutttttttttqttttttttttq\r\n" +
                "qtttttttqqqtttttuiuttttoottttttuuttttttq\r\n" +
                "qtttttttttttttttttttttttottttttttttttttq\r\n" +
                "qtttttttxxtqqqtttttttqqqxttttttttotttttq\r\n" +
                "qtttqotttttttttttttttqtttttttttttttttttq\r\n" +
                "qtttqtttttttttttttutttttttuttttttqtttttq\r\n" +
                "qttttttuttttttqtttttottttttttttttqtttttq\r\n" +
                "qttuttttttttttttttttotttttttttttqttttttq\r\n" +
                "qttttttttqxttttttttototttttttttttttttttq\r\n" +
                "qtttttttttqttttuttttottqqttttuiutttttttq\r\n" +
                "qttttutttttqtttttttttttqottttttttttttttq\r\n" +
                "qtttttttttttqtttttttttqqxttttttttqqttttq\r\n" +
                "qottqtttttttttttutttttttttttutttttqttttq\r\n" +
                "qottqxtttttttttuttttttttttttutttttqttttq\r\n" +
                "qottqttttttuottttttqqqtttttutttttttttttq\r\n" +
                "qottqqqqttttttttttttttttttttttttttxttttq\r\n" +
                "qxtttttttttttttttttetttttttttttttttttttq\r\n" +
                "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq",7);
		this.map.createMapToChars();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testEnemy method.
	 * Checks the basic sprite name, character and strategy of the enemy.
	 */
	@Test
	public void testEnemy() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Enemy.png";
		final char expectedCharName = 'i';
		entity.setStrategy(new RandomEnemyMove((Enemy)entity));
		final String expectedStrategy = "RandomEnemyMove";
		assertEquals(expectedCharName, entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, entity.getSprite().getImageName());
		assertEquals(expectedStrategy, entity.getStrategy().returnStrategy()); 
	}
	
	/**
	 * Runs the map's entities strategies. Consequence : stone fall on the enemy.
	 * Check the latter death.
	 */
	@Test
	public void testDeathOfEnemy() {
		
		final int expectedDiamondCounter = 4;
		for (int i=0;i<50;i++) {
            map.runStrategies();
        }
       
        assertEquals(expectedDiamondCounter, map.getPlayer().getDiamondsCounter());
	}

}
