package com.dpoli.chainofresponsibility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dpoli.strategy.Budget;

public class CalculateDiscountsTest {

	private static final double DELTA = 0.00001;

	@Test
	public void testNoDiscount() {

		CalculateDiscounts discounts = new CalculateDiscounts();

		Budget budget = new Budget(500.0);
		budget.addItem(new Item("Tablet", 250.0));
		budget.addItem(new Item("Laptop", 850.0));

		double finalDiscount = discounts.calculate(budget);

		// No discount
		assertEquals(0, finalDiscount, DELTA);
	}

	@Test
	public void testMoreThanFiveItemsDiscount() {

		CalculateDiscounts discounts = new CalculateDiscounts();

		Budget budget = new Budget(5000.0);
		budget.addItem(new Item("Tablet", 250.0));
		budget.addItem(new Item("Laptop", 850.0));
		budget.addItem(new Item("Mouse", 25.0));
		budget.addItem(new Item("Keyboard", 50.0));
		budget.addItem(new Item("Coffee Machine", 450.0));
		budget.addItem(new Item("Smartphone", 600.0));

		double finalDiscount = discounts.calculate(budget);

		// 10% discount
		assertEquals((5000 * 0.1), finalDiscount, DELTA);
	}

	@Test
	public void testMoreThan500DollarsDiscount() {

		CalculateDiscounts discounts = new CalculateDiscounts();

		Budget budget = new Budget(5000.0);
		budget.addItem(new Item("Tablet", 250.0));
		budget.addItem(new Item("Laptop", 850.0));
		budget.addItem(new Item("Mouse", 25.0));

		double finalDiscount = discounts.calculate(budget);

		// 7% discount
		assertEquals((5000 * 0.07), finalDiscount, DELTA);
	}
}
