package com.test.extentreport;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
	}

}
