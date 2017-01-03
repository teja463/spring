package com.teja.spring.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.Assert;
import junit.framework.TestCase;

public class FirstMainTest extends TestCase {

	private static final Log logger = LogFactory.getLog(FirstMainTest.class);
	
	public void testMain() {
		logger.debug("main test case..");
		Assert.assertTrue(true);
	}

	public void test2(){
		Assert.assertEquals(true, true);
	}
}
