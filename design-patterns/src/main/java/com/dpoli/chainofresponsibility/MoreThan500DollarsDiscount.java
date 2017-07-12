package com.dpoli.chainofresponsibility;

import com.dpoli.strategy.Budget;

public class MoreThan500DollarsDiscount implements Discount {

	private Discount nextDiscount;

	@Override
	public double discount(Budget budget) {
		if (budget.getValue() > 500) {
			// 7% discount
			return budget.getValue() * 0.07;
		} else {
			return nextDiscount.discount(budget);
		}
	}

	@Override
	public void setNext(Discount nextDiscount) {
		this.nextDiscount = nextDiscount;
	}
}
