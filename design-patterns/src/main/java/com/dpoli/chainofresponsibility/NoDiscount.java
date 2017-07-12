package com.dpoli.chainofresponsibility;

import com.dpoli.strategy.Budget;

public class NoDiscount implements Discount {

	@Override
	public double discount(Budget budget) {
		// No discount will be given.
		return 0;
	}

	@Override
	public void setNext(Discount nextDiscount) {
		// Do nothing, once it is the last element in the chain.
	}

}
