package com.test.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

	private FakerUtils() {
		
	}
	
	private static Faker faker=new Faker();
	
	public static String getName() {
		return faker.gameOfThrones().character();
	}
	
	public static String getDescription() {
		return faker.gameOfThrones().house();
	}
	
	public static int getNumber(int startingNum, int endingNum) {
		return faker.number().numberBetween(startingNum, endingNum);
		
	}
}
