package com.databaseconnection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The DBPropertiesTest class.
 * @author BOLOG Israel
 * @author Fruissala KANWER
 * @version 1.0
 *
 */
public class DBPropertiesTest {
	
	/** The DBProperties used for the tests */
	static DBProperties dpProperties;

	/**
	 * Instantiates a new DBProperties
	 * @throws Exception in case of an exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dpProperties = new DBProperties();
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
	 * Checks that the correct url, login and password are used to connect to the database.
	 */
	@Test
	public void testProperties() {
		
		final String url = "jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false";
		final String login = "root";
		final String password = "";
		
		assertEquals(url, dpProperties.getUrl());
		assertEquals(login, dpProperties.getLogin());
		assertEquals(password, dpProperties.getPassword());
	}

}
