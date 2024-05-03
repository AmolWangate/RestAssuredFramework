package com.test.extentreport;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> tlExtentTest = new ThreadLocal<>();

	static synchronized void setExtentTest(ExtentTest extentTest) {
		tlExtentTest.set(extentTest);
	}

	public static synchronized ExtentTest getExtentTest() {
		return tlExtentTest.get();
	}

	static synchronized void unload() {
		tlExtentTest.remove();
	}

}
