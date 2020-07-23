/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The ModelTest class.
 * @author  BOLOG Israel
 * @author Fruissala KANWER
 * @version 1.0
 *
 */
public class ModelTest {
	
	/** The model for the tests */
    private Model model;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * Instantiates a new model.
     * @throws Exception in case of an exception
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testContentOfMap() {
      Assert.assertEquals("", this.model.getMap().getContentOfMap());
    }


    /**
     * The testGetNumberOfDiamondsNeeded method.
     * Check that the connection to the database if well-established and the correct number of diamonds is picked.
     */
    @Test
    public void testGetNumberOfDiamondsNeeded() {
        this.model.loadMap(1);
        Assert.assertEquals(3, this.model.getMap().getNumberOfDiamondsNeeded());
        this.model.loadMap(2);
        Assert.assertEquals(5, this.model.getMap().getNumberOfDiamondsNeeded());
        this.model.loadMap(3);
        Assert.assertEquals(7, this.model.getMap().getNumberOfDiamondsNeeded());
        this.model.loadMap(4);
        Assert.assertEquals(9, this.model.getMap().getNumberOfDiamondsNeeded());
        this.model.loadMap(5);
        Assert.assertEquals(10, this.model.getMap().getNumberOfDiamondsNeeded());
    }
    
    /**
     * Test the limit of level loading. If there is an exception, assertEquals will return true
     */
    @Test
    public void testLimitLoadingMap() {

        try {
        	this.model.loadMap(8);
            fail("Failed");
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), "Incorrect id !"); 
        }
    }
    
    
    
    /**
     * Verify the correct content of the map is picked from the database depending on the level.
     */
    @Test
    public void testGetContentOfMap() {
        this.model.loadMap(1);
        assertEquals("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" + 
        		"qttttttttttttttttttttttttttttttttttttttq\r\n" + 
        		"qtootttttxttttttttttttuotttttttttuuttttq\r\n" + 
        		"qttttttttttttttttttttuuttttttttttxtttttq\r\n" + 
        		"qttyuttttttttttttttttttttttttttttttttttq\r\n" + 
        		"qtttttuuuttttttttttutttttttttttttttttttq\r\n" + 
        		"qttttttttxttttttttuuuttttttttttttttttttq\r\n" + 
        		"qttttttttttttttttttutttttttttttttttttttq\r\n" + 
        		"qqqqqqqqqqqqqqqqqqqqqqqqootttttxtttqqqqq\r\n" + 
        		"qttttttttxtttttttttttttttttttutttttttttq\r\n" + 
        		"qttttttttttttttttttttttttttttutttttttttq\r\n" + 
        		"qttttttttttttttttttutttttttttttttttttttq\r\n" + 
        		"qtttttttttoottttttttuttttttttttttttttttq\r\n" + 
        		"qtttttttttxtttttttttuttttttttotttttttttq\r\n" + 
        		"qttttttttttttttttttttttttttttxottttttttq\r\n" + 
        		"qttttttttttttttttttttttttttttttttttttttq\r\n" + 
        		"qttttttuututtttttttttttttttttttttttttttq\r\n" + 
        		"qqqqqtttttutttttttqqqqqqqqqqqqqqqqqqqqqq\r\n" + 
        		"qttttttttuutttttttttttttttttttttxttttttq\r\n" + 
        		"qtttttttttuttotttttttttttttttttttttttttq\r\n" + 
        		"qttttutttttttoottttttttttttttttttttttttq\r\n" + 
        		"qttttuutttttttttttttttttttottttttttttttq\r\n" + 
        		"qttttuttttttottttttuuuttttotttttttottttq\r\n" + 
        		"qtttttttttttttttttttttttttotttttttottttq\r\n" + 
        		"qttttxuuttttttttttttttttttxtttttttottttq\r\n" + 
        		"qtttttttttttootttttttttttttttttttttttttq\r\n" + 
        		"qttttttttttttttttttttttttotttttttttttttq\r\n" + 
        		"qqqqqqqqqqqqqqqqqqtttttuuuttttttttqqqqqq\r\n" + 
        		"qttootttttttttttttttttttuutttttttttttttq\r\n" + 
        		"qtttttttttuuttttttttttttuuuttttttttttttq\r\n" + 
        		"qtttttttttootttttttttttttttttttttttttttq\r\n" + 
        		"qttttttttttxtttttotttttttttttttttutttttq\r\n" + 
        		"qttttttttttxttttttttuutttttttttttxuttttq\r\n" + 
        		"qtttttxotttttttttttttttttttttttttttttttq\r\n" + 
        		"qttttttttttttutttttttttttttutttttttttteq\r\n" + 
        		"qttttuutttttttuttttttttttttttttotttttttq\r\n" + 
        		"qttttutttttttttttttxtttttttttttttttttttq\r\n" + 
        		"qttttttttttttttttttttttttttttttttttttuuq\r\n" + 
        		"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", this.model.getMap().getContentOfMap());
        this.model.loadMap(2);
        assertEquals("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" + 
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
        		"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", this.model.getMap().getContentOfMap());
        this.model.loadMap(3);
        assertEquals("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" + 
        		"qtttttttttttqttttttttttttttqtttttoxttttq\r\n" + 
        		"qtttttttttttqtttttttyttttttqtttttttttttq\r\n" + 
        		"qtttttttttttqtottttttttttttqttttttottttq\r\n" + 
        		"qttxttttttttqttotttttttotttqootttttttttq\r\n" + 
        		"qtttttttttttqtotottttttttttqootttttttttq\r\n" + 
        		"qtttttttttttqtottttttttttttqootttttttttq\r\n" + 
        		"qttttuiuttttqttttttoottttttqtttttttttttq\r\n" + 
        		"qtotttttttttqtttttttxttttttqtttttttxtttq\r\n" + 
        		"qtttttttttttqttttuuuiuuutttqtttttttttttq\r\n" + 
        		"qttttttttttttttttttttttttttttttttttttttq\r\n" + 
        		"qttttxtttttttttttqqqqqqqttttttuttttttttq\r\n" + 
        		"qttttttttttttttttttttttttttttttttttttttq\r\n" + 
        		"qttottttotttttttttttxtttttttottttttttttq\r\n" + 
        		"qootttttqqqqqqqqqqqqqqqqqqqqqqqqtttttttq\r\n" + 
        		"qttttttttoootttttttttttttttttttttttttttq\r\n" + 
        		"qttttttttttottttttttotttttttttttuutttttq\r\n" + 
        		"qtxtttttttotttttttttottttttttttttttttttq\r\n" + 
        		"qtttttttttttttttttuototttttttttttttttttq\r\n" + 
        		"qqqqqqqqqqqqqtttttttottttttqqqqqqqqqqqqq\r\n" + 
        		"qtttttttttttottttttttttttttttttttttttttq\r\n" + 
        		"qtootttttttttttttttoottuttttttttttttxttq\r\n" + 
        		"qtttoottttttutttttuttttttttttttttttttttq\r\n" + 
        		"qtttttttttttittotttttttttttttttttttttttq\r\n" + 
        		"qtttttttqqqqqqqqqqqqqqqqqqqqqqqqtttttttq\r\n" + 
        		"qttttttttttttttoootttttttttttttttttttttq\r\n" + 
        		"qttttotttttttttoxttttttttttttoouuuuttttq\r\n" + 
        		"qttottttttttttttxqqqqqqqttttttottttttttq\r\n" + 
        		"qttttttottttttttxtttttttttttttottttttttq\r\n" + 
        		"qtttttttttttqttttuuuiuuutttqttttttttuttq\r\n" + 
        		"qttuutttttttqttttttttttttttqtttttttttttq\r\n" + 
        		"qtttotttttttqttttttttttttttqtttutttttttq\r\n" + 
        		"qttttottttttqtttttottotttttqtttttttttttq\r\n" + 
        		"qtttutotttttqttxttttottttotqtoooottttttq\r\n" + 
        		"qtttuttottttqtttttottttttttqttootttttttq\r\n" + 
        		"qttxttttttttqttttttttttttttqtttttttttttq\r\n" + 
        		"qtttttttttttqtttttttttuutttqtttxxttttttq\r\n" + 
        		"qtttttttttttqttttttuettttttqtttttttttttq\r\n" + 
        		"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", this.model.getMap().getContentOfMap());
        this.model.loadMap(4);
        assertEquals("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" + 
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
        		"qttytttttttttttttttttxttttttqqtttttxtttq\r\n" + 
        		"qtttttttttttttttttttttttttttqttttttttttq\r\n" + 
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
        		"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", this.model.getMap().getContentOfMap());
        this.model.loadMap(5);
        assertEquals("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" + 
        		"qttxotttttutttuttttttttttttttttoxotttttq\r\n" + 
        		"qttxoutttttttttttttyutttttttttttttttuttq\r\n" + 
        		"qttttttttttotttttttuutttttotttttottttttq\r\n" + 
        		"qttttttttttottttttttttttttotottttttttttq\r\n" + 
        		"qttttqqqqqqqqqqqqquttqqqqqqqqqqqqqqttttq\r\n" + 
        		"qtuttqttttttttttttttttottttottttttqttttq\r\n" + 
        		"quuttqtttxttttttotttttttttototttttqtuttq\r\n" + 
        		"qotttqtttttttttottttttttttttttttttqttttq\r\n" + 
        		"qttttqtttttttttttttqttttttttttttttqttttq\r\n" + 
        		"qttttqttttotttttttoqtttuttttttxxttqttttq\r\n" + 
        		"qotttqttttottttttotqttttutttttttttqtootq\r\n" + 
        		"qttttqtttototttttttqttttutttttttttqttttq\r\n" + 
        		"qttttqttttottttttttqttttttttttttttqttttq\r\n" + 
        		"qttttqtttttttttttttqtttuuiuuttttttqttttq\r\n" + 
        		"qttttqttttttootttotqttttttttttttttqttttq\r\n" + 
        		"qtttuouttttttttttttqttttttttottttttttttq\r\n" + 
        		"qttttottttttttttttttttttttttttttottttttq\r\n" + 
        		"qttttottttttqqqqqqtxtqqqqqqttttttotttttq\r\n" + 
        		"qtttttttttttttttttttttttttttttttttottttq\r\n" + 
        		"qtttttttttttottttttqttttuttttttttttotttq\r\n" + 
        		"quuttqttttttooottttqttttttttttttttqutttq\r\n" + 
        		"qttttqtttttttttttttqtuutttttotttttqitttq\r\n" + 
        		"qxtttqtttttutttttttqttttttttotttttqutttq\r\n" + 
        		"qttttqtttttittttttoqtxtttttotottttqttttq\r\n" + 
        		"qttttqtttttutttttooqttttttttotttttqttttq\r\n" + 
        		"qttttqttttttttttoooqtootttttttttttqttttq\r\n" + 
        		"qttttqutttttuttttttqttttttttttttttqttttq\r\n" + 
        		"qttttqttottttttttttqtttttttxttttttqttttq\r\n" + 
        		"qttotqttttttttottttqtttttttttttottqttttq\r\n" + 
        		"qttttqoooottttttttttttotutttttttttqttooq\r\n" + 
        		"qttttqttxttttttttttttttttttttottttqttotq\r\n" + 
        		"qttttqtttttttoutttttttttttttotttttqttttq\r\n" + 
        		"qttttqqqqqqqqqqqqqtuuqqqqqqqqqqqqqqttttq\r\n" + 
        		"qtttttttuoutttuutttttttttttttttotttttttq\r\n" + 
        		"qttotttttotttttxttttttotttttttooottttttq\r\n" + 
        		"qoootttttottttttttttttttottttxxtttttttoq\r\n" + 
        		"qoooxttttttttttttttettttttttttttttttttoq\r\n" + 
        		"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", this.model.getMap().getContentOfMap());
    }
}