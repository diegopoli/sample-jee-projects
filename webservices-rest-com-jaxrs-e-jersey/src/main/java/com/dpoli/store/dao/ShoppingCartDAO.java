package com.dpoli.store.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.dpoli.store.model.Product;
import com.dpoli.store.model.ShoppingCart;

public class ShoppingCartDAO {

	private static Map<Long, ShoppingCart> database = new HashMap<>();
	private static AtomicLong counter = new AtomicLong(1);

	static {
		Product soccer = new Product(6237, "FIFA 2017", 4000, 1);
		Product basketball = new Product(3467, "NBA 2K17", 60, 2);
		ShoppingCart shoppingCart = new ShoppingCart()
				.add(soccer)
				.add(basketball)
				.setData("795 El Camino Real", "Palo Alto, CA")
				.setId(1l);
		database.put(1l, shoppingCart);
	}

	public void add(ShoppingCart shppingCart) {
		long id = counter.incrementAndGet();
		shppingCart.setId(id);
		database.put(id, shppingCart);
	}

	public ShoppingCart search(Long id) {
		return database.get(id);
	}

	public ShoppingCart remove(long id) {
		return database.remove(id);
	}
}
