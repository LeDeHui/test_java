package com.JDBC.day02;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class BeanUtilsTest {

	@Test
	public void testSetProperty() throws Exception {
		Object object = new Student();
		BeanUtils.setProperty(object, "idcard", "211211");
		System.out.println(object);

	}

}
