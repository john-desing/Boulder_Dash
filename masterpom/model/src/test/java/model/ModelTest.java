package model;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IController;
import contract.IView;


public class ModelTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	private Model model;

	@Before
	public void setUp() throws Exception {
		model = new Model();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPosition() {
	//	model.loadMap(1);
		int expectedX = 1;
		int expectedY = 18;
	//	assertEquals(expectedX, model.getDoorX());
	//	assertEquals(expectedY, model.getDoorY());
	}
	@Test
	public void testPlayer() {
	//	model.loadMap(2);
		int expectedX = 1;
		int expectedY = 1;
	//	assertEquals(expectedX, model.getCharacter().posX);
//		assertEquals(expectedY, model.getCharacter().posY);
	}

}
