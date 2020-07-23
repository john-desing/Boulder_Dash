package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The MapTest class.
 * @author Israel BALOG
 * @version 1.0
 *
 */
public class MapTest {
	
	/** The map for the test */
	static Map map;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map = new Map(1 , "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" + 
				"qtttootttttttttttttqtttttttttttttttttttq\r\n" + 
				"qtttxttttttttttttttqtotttoottttttttxtttq\r\n" + 
				"qtttxttttttttttttttqtttttttttttttttttttq\r\n" + 
				"qttttttttoooootttttqttttuuiutttotttttttq\r\n" + 
				"qttttttttttttttttttqtttttttttttoottttttq\r\n" + 
				"qtttttttttuuiutttttqtttttttttttoottttttq\r\n" + 
				"qqqqqqqqttttqqqqqqqqqqqqqqqquuttqqqqqqqq\r\n" + 
				"qttttttttttttttttttqtttttttttttttttttttq\r\n" + 
				"qtttuuuttttttttttttqttttttttuttttttttttq\r\n" + 
				"qttttttttxttottttttqtttttttttttttttotttq\r\n" + 
				"qtootttttttotttttttqtttttutttutttttotttq\r\n" + 
				"qttotttttttttttttttotttttttttxttttotottq\r\n" + 
				"qtttottttutttttttttttttttttttttttttotteq\r\n" + 
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
				"qttyuttttttttxtttutqottotttttttutttttttq\r\n" + 
				"qttuutttttttttttuutqottttttotttutttttttq\r\n" + 
				"qttttttttttttttttttqxxtttttttttttttttttq\r\n" + 
				"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", 10);
		map.createMapToChars();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new map and its entities.
	 */
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Verifiy that there is a player entity on the map and therefore the transformation of the String into entities worked well.
	 */
	@Test
	public void testMapFulfilled() {
		assertNotNull(map.getPlayer());
	}

}
