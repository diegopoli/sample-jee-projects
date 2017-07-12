package com.dpoli.chainofresponsibility;

import com.dpoli.strategy.Budget;

public class CalculateDiscounts {

	public double calculate(Budget budget) {

		Discount firstDiscount = new MoreThanFiveItemsDiscount();
		Discount secondDiscount = new MoreThan500DollarsDiscount();
		Discount noDiscount = new NoDiscount();

		// Sets up next discounts.
		firstDiscount.setNext(secondDiscount);
		secondDiscount.setNext(noDiscount);

		// Retrieves the chained discounts from firstDiscount object.
		// If firstDiscount fails, the secondDiscount takes place, and so on.
		return firstDiscount.discount(budget);
	}
}
