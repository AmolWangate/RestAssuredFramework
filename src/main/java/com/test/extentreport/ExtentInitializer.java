package com.test.extentreport;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentInitializer {

	private ExtentInitializer() {

	}

	private static ExtentReports extentReports;

	public static void initReport() {
		if (Objects.isNull(extentReports)) {
			extentReports = new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Extenrt-report.html");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setDocumentTitle("Rest Assured Report");
			sparkReporter.config().setReportName("Regression report");
			sparkReporter.config().setEncoding("UTF-8");
			extentReports.attachReporter(sparkReporter);
		}
	}

	public static void flushReport() {
		if (Objects.nonNull(extentReports)) {
			extentReports.flush();
			ExtentManager.unload();
		}
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
	}

	public static void setAuthor(String[] authorNames) {
		for (String author : authorNames) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}
	}

	public static void setModule(String moduleName) {
		ExtentManager.getExtentTest().assignCategory(moduleName);
	}

}
