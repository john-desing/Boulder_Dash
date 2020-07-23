package entity;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The EntityTest class.
 * @author John MBOKO
 * @version 1.0
 *
 */
public abstract class EntityTest {
	
	/** The entity for the test */
	protected static Entity entity;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Only for the example.
	 * @throws Exception in case of an exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Verify the sprite, x position and y position
	 */
	@Test
	public void testEntityBasicCharacteristics() {
		assertNotNull(entity.getSprite());
		assertNotNull(entity.getPositionX());
		assertNotNull(entity.getPositionY());
	}
}
