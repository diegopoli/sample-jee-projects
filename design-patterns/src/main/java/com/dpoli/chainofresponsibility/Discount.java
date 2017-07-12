package com.dpoli.chainofresponsibility;

import com.dpoli.strategy.Budget;

public interface Discount {

	double discount(Budget budget);

	void setNext(Discount nextDiscount);
}
