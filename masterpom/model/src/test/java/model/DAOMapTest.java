package model;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.databaseconnection.DBConnection;

/**
 * The DAOPMapTest class.
 * @author BOLOG Israel
 * @author Fruissala KANWER
 * @version 1.0
 *
 */
public class DAOMapTest {
	
	/** The DAOMap for the tests */
	private static DAOMap daoMap;

	/** 
	 * Instantiates a new DAOMap.
	 * @throws Exception in case of an exception
	 */ 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoMap = new DAOMap(DBConnection.getInstance().getConnection());
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
	 * Verify the connection is correct with the database for the levels.
	 */
	@Test
	public void testGetMapFromDatabase() {
		
		
		assertNotNull(DAOMapTest.daoMap.find(1));
		assertNotNull(DAOMapTest.daoMap.find(2));
		assertNotNull(DAOMapTest.daoMap.find(3));
		assertNotNull(DAOMapTest.daoMap.find(4));
		assertNotNull(DAOMapTest.daoMap.find(5));

	}

}
