package main;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import contract.ControllerOrder;
import controller.Controller;
import entity.Entity;
import model.Model;
/**
 * character class
 * @author TEAM 11
 * @since 24-05-20
*/


public class TestController {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	private Controller controller;
	private Model model;

	@Before
	public void setUp() throws Exception {
		model = new Model();
		controller = new Controller(null,model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayerMovement() {
	//	model.loadMap(1);
		int expectedX = 1;
		int expectedY = 2;
	//	controller.swap(model.getTabEntity(),model.getMap(),39);
	//	assertEquals(expectedX, model.getCharacter().posX);
	//	assertEquals(expectedY, model.getCharacter().posY);
	}
	@Test
	public void TestGetDiamond( ) {
	//	model.loadMap(1);
		int expectedDiamond = 1;
	//	controller.swap(model.getTabEntity(), model.getMap(), 39);
	//	assertEquals(expectedDiamond, model.getCharacter().getNbDiamond());
	}
}
