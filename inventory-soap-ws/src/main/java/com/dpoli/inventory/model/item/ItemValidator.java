package com.dpoli.inventory.model.item;

import java.util.ArrayList;
import java.util.List;

public class ItemValidator {

	private Item item;

	public ItemValidator(Item item) {
		this.item = item;
	}

	public void validate() {
		List<String> errors = new ArrayList<>();

		String code = item.getCode();
		if (isEmpty(code) || code.length() != 3) {
			errors.add("Invalid code");
		}

		String name = item.getName();
		if (isEmpty(name) || name.length() < 3) {
			errors.add("Invalid name");
		}

		int quantity = item.getQuantity();
		if (quantity <= 0) {
			errors.add("Invalid quantity");
		}

		String type = item.getType();
		if (isEmpty(type) || !ItemType.exists(type)) {
			errors.add("Invalid type");
		}

		if (!errors.isEmpty()) {
			throw new ItemValidatorException(errors);
		}
	}

	private boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}
}
