package com.dpoli.strategy;

public class CalculateTaxes {

	public double calculate(Budget budget, Tax tax) {
		return tax.calc(budget);
	}
}
