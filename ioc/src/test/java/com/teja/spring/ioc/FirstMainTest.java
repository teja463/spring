package com.teja.spring.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;


public class FirstMainTest {

	private static final Log logger = LogFactory.getLog(FirstMainTest.class);
	
	@Test
	public void testMain() {
		logger.info("main test case..");
		Assert.assertTrue(true);
	}

	@Test
	public void test2(){
		logger.debug("test case 2..");
		logger.debug("some more text");
		Assert.assertEquals(true, true);
	}
}
