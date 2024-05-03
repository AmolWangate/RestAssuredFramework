package com.test.utils;

public final class RandomUtils {

	private RandomUtils() {
		
	}
	
	public static String getName() {
		return FakerUtils.getName();
	}
	
	public static String getDescription() {
		return FakerUtils.getDescription();
	}
	
	public static int getNumber() {
		return FakerUtils.getNumber(1, 100000);
	}
}
