package com.dpoli.strategy;

import org.junit.Assert;
import org.junit.Test;

public class CalculateTaxesTest {

	private static final double DELTA = 0.00001;

	@Test
	public void testCalcICMS() {

		Tax icms = new ICMS();
		Budget budget = new Budget(500.0);
		CalculateTaxes calculateTaxes = new CalculateTaxes();
		double value = calculateTaxes.calculate(budget, icms);

		Assert.assertEquals((500.0 * 0.1), value, DELTA);
	}

	@Test
	public void testCalcISS() {

		Tax iss = new ISS();
		Budget budget = new Budget(500.0);
		CalculateTaxes calculateTaxes = new CalculateTaxes();
		double value = calculateTaxes.calculate(budget, iss);

		Assert.assertEquals((500.0 * 0.06), value, DELTA);
	}
}
