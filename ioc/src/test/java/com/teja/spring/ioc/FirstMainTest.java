package com.teja.spring.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;


public class FirstMainTest {

	private static final Log logger = LogFactory.getLog(FirstMainTest.class);
	
	@Test
	public void testMain() {
		logger.debug("main test case..");
		Assert.assertTrue(true);
	}

	@Test
	public void test2(){
		Assert.assertEquals(true, true);
	}
}
