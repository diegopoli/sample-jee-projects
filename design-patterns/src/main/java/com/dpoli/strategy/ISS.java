package com.dpoli.strategy;

public class ISS implements Tax {

	@Override
	public double calc(Budget budget) {
		return budget.getValue() * 0.06;
	}
}
