package com.fsd.book;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleBookDetailsApplicationTests {
	
	private static BookDetailsApplication jerseySpringBoot;
	private static String[] args;
	private static String[] argsTwo;

	@BeforeClass
	public static void init() throws Exception {
		jerseySpringBoot = new BookDetailsApplication();
		argsTwo = new String[0];
		args = new String[1];
		args[0] = "exitcode";
	}

	@AfterClass
	public static void destroy() {
		jerseySpringBoot = null;
		args = null;
		argsTwo = null;
	}

	@Test
	public void testMain() {
		try {
			BookDetailsApplication.main(argsTwo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To check the main method null args and get exception
	 * 
	 * @throws Exception
	 */
}
