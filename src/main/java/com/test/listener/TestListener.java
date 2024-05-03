package com.test.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.annotations.TestAnnotation;
import com.test.extentreport.ExtentInitializer;
import com.test.extentreport.ExtentLogger;

public class TestListener implements ISuiteListener, ITestListener {
	
	private static final Logger LOG=LogManager.getLogger();

	@Override
	public void onStart(ISuite suite) {
		ExtentInitializer.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentInitializer.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentInitializer.createTest(result.getMethod().getDescription());
		ExtentInitializer.setAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestAnnotation.class).author());
		ExtentInitializer.setModule(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestAnnotation.class).module());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getDescription());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getThrowable().toString());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getThrowable().toString());
	}
}
