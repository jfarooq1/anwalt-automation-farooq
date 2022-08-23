package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentSparkReporter reporter;
	static ExtentReports extent;

	public static ExtentReports getReport() {
		String path = System.getProperty("user.dir") + "/reports/index.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Farooq");
		return extent;

	}
}
