package com.entity.motionlesselements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.EntityTest;

/**
 * The DirtTest class.
 * @author Anthony FOUDA
 * @author John MBOKO
 * @version 1.0
 *
 */
public class DirtTest extends EntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Dirt(4,4);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new dirt.
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testDirt method.
	 * Checks the basic sprite name, character and strategy of the dirt.
	 */
	@Test
	public void testDirt() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Dirt.png";
		final char expectedCharName = 't';
		assertEquals(expectedCharName, entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, entity.getSprite().getImageName());
		assertNull(entity.getStrategy());
	}
}
