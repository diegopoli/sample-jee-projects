package com.dpoli.strategy;

public class ICMS implements Tax {

	@Override
	public double calc(Budget budget) {
		return budget.getValue() * 0.1;
	}
}
