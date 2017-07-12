package com.dpoli.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SingletonPatternTest {

	@Test
	public void testSingletonInstance() {

		SingleObject object = SingleObject.getInstance();

		assertNotNull(object);
		assertEquals(SingleObject.class.getSimpleName(), object.getClassName());
	}

	@Test
	public void testSingletonSameInstance() {

		SingleObject object = SingleObject.getInstance();

		assertEquals(SingleObject.getInstance(), object);
	}
}
