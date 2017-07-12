package com.dpoli.chainofresponsibility;

import com.dpoli.strategy.Budget;

public class MoreThanFiveItemsDiscount implements Discount {

	private Discount nextDiscount;

	@Override
	public double discount(Budget budget) {
		if (budget.getItems().size() > 5) {
			// 10% discount
			return budget.getValue() * 0.1;
		} else {
			return nextDiscount.discount(budget);
		}
	}

	@Override
	public void setNext(Discount nextDiscount) {
		this.nextDiscount = nextDiscount;
	}
}
