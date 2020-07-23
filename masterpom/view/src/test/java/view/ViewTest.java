package view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;

/**
 * The ViewTest class.
 * @author Anthony FOUDA
 * @version 1.0
 *
 */
public class ViewTest {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Check for each specific touch the player can use that the result is the right one.
	 */
	@Test
	public void testControllerOrderReturn() {
		
		final ControllerOrder expectedZ = ControllerOrder.Z;
		
		assertEquals(expectedZ, View.keyCodeToControllerOrder(KeyEvent.VK_Z));
		
		final ControllerOrder expectedQ = ControllerOrder.Q;
		
		assertEquals(expectedQ, View.keyCodeToControllerOrder(KeyEvent.VK_Q));
		
		final ControllerOrder expectedS = ControllerOrder.S;
		
		assertEquals(expectedS, View.keyCodeToControllerOrder(KeyEvent.VK_S));
		
		final ControllerOrder expectedD = ControllerOrder.D;
		
		assertEquals(expectedD, View.keyCodeToControllerOrder(KeyEvent.VK_D));
		
		final ControllerOrder expectedNothing = ControllerOrder.nothing;
		
		assertEquals(expectedNothing, View.keyCodeToControllerOrder(KeyEvent.VK_R));
		
	}

}
