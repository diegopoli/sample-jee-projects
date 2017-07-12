package com.dpoli.singleton;

public class SingleObject {

	// Create an object of SingleObject.
	private static SingleObject instance = new SingleObject();

	// Make the constructor private so that this class cannot be instantiated.
	private SingleObject() {
	}

	// Get the only object available.
	public static SingleObject getInstance() {
		return instance;
	}

	public String getClassName() {
		return instance.getClass().getSimpleName();
	}
}
