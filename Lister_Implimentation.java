package common_utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Lister_Implimentation implements ITestListener {
	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
	
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		String methodName=result.getMethod().getMethodName();
		//to add information to the html report
		Reporter.log(methodName+"Testscript execution is passed",true);
	
		
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message=result.getThrowable().toString();
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is failed"+message,true);
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is skipped",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("Testscript execution is started",true);
		
		ExtentSparkReporter reporter1=new ExtentSparkReporter("./extentreport/report12.html");
		reporter1.config().setDocumentTitle("vtigercrm");
		reporter1.config().setTheme(Theme.STANDARD);
		reporter1.config().setReportName("shraddha");
		
		//it is used to generate the extend report
		 report=new ExtentReports();
		
		//to attach the configuration to the report(add name of report)
		report.attachReporter(reporter1);
		report.setSystemInfo("OS","window" );
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("chromeversion", "120");
		report.setSystemInfo("author", "shraddha pejgude");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Testscript execution is finished",true);
		report.flush();

	}
	

}
