package com.entity.mobileelements;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.EntityTest;

/**
 * The StoneTest class.
 *
 * @author John MBOKO
 * @version 1.0
 *
 */
public class StoneTest extends EntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Stone(7,7);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new stone.
	 *
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testStone method.
	 * Checks the basic sprite name, character and strategy of the stone.
	 */
	@Test
	public void testStone() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Stone.png";
		final char expectedCharName = 'o';
		final String expectedStrategy = "CascadeFalling";
		assertEquals(expectedCharName, entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, entity.getSprite().getImageName());
		assertEquals(expectedStrategy, entity.getStrategy().returnStrategy());
	}
}
