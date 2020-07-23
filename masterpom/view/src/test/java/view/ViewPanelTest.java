package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The viewPanelTest class.
 * @author ISRAEL BALOG
 * @version 1.0
 *
 */
public class ViewPanelTest {
	
	/** The view panel for the test */
	static ViewPanel vp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new view panel.
	 * @throws Exception in case of an exception
	 */
	@Before
	public void setUp() throws Exception {
		vp = new ViewPanel();
	}

	@After
	public void tearDown() throws Exception {
	}

	 /**
	 * Test the limit value for the timer.
	 */
	@Test
	    public void testCounter() {
	        try {
	            vp.setCounter(-100);
	            ViewPanel.startTimer();
	            fail("Failed");
	        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
	            assertEquals(anIndexOutOfBoundsException.getMessage(), "Wrong parameters"); // If there is an exception, the assert equals will return true
	        }
	    }
}
