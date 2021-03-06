package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class C_extentLogswithChildNodes {

	public static void main(String[] args) {

		System.out.println("Start");

		// Report will generate in Project Directory only.
		// After execution, refresh project directory.
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(".\\Report\\C_extentLogswithChildNodes.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlreport);

		// This is the object of extentTest class, by which log is generate.
		ExtentTest testlog;

		// Customize Report property
		htmlreport.config().setReportName("Test Report");
		reports.setSystemInfo("Host Name", "Test Host");
		reports.setSystemInfo("Environment", "Automation Testing");
		reports.setSystemInfo("User Name", "QA Automation");
		htmlreport.config().setDocumentTitle("Automation Report");

		// Two default theme of report
		// htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setTheme(Theme.DARK);

		testlog = reports.createTest("Test Log Method-1");
		testlog.info("This is Info log");
		testlog.pass("This is Pass log");
		testlog.fail("This is Fail log");
		testlog.error("This is Error log");

		testlog = reports.createTest("Test Log Method-2");
		testlog.log(Status.INFO, "This is Info log");
		testlog.log(Status.PASS, "This is Pass log");
		testlog.log(Status.FAIL, "This is Fail log");
		testlog.log(Status.FATAL, "This is Fatal log");

		testlog = reports.createTest("Test log with Extent Color");
		testlog.log(Status.INFO, MarkupHelper.createLabel("This is Info log", ExtentColor.ORANGE));
		testlog.log(Status.PASS, MarkupHelper.createLabel("This is pass log", ExtentColor.CYAN));
		ExtentTest childLog;

		// Child test object to integrate with Parent test
		// It will append with Last test section
		childLog = testlog.createNode("Child Test Section-1");
		childLog.info("This is Info log");
		childLog.pass("This is Pass log");
		childLog.fail("This is Fail log");

		childLog = testlog.createNode("Child Test Section-2");
		childLog.info("This is Info log");
		childLog.pass("This is Pass log");
		childLog.fail("This is Fail log");

		// If flush method did not call, Report will not generate.
		reports.flush();
		System.out.println("End");
	}
}
