package generic_Lib;

import object_Repo.MasterOR;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import propertyfiles.Messages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {

	public Common_Lib common = new Common_Lib();
	public Excel_Lib excel = new Excel_Lib();
	public MasterOR OR = null;
	public ExtentReports reports;
	public ExtentTest logger;
	public Sync_lib wait = new Sync_lib();
	public Sikuli Sikuli = new Sikuli();


	@BeforeTest
	public void BeforeTest() {

		common.BrowserCalling(Messages.getString("Browser"));
		//		reports = new ExtentReports("ExtentReports//"+getClass().getSimpleName()+".html", true);
		reports = new ExtentReports(getClass().getSimpleName()+".html", true);
		//		reports.loadConfig(new File(".\\Framework_Maven\\Extent_config.xml"));
		OR  = new MasterOR();
	}


	@AfterTest
	public void AfterTest(){
		//		common.Quit();
		reports.endTest(logger);
		reports.flush();
		reports.close();
	}


	@AfterMethod
	public void AfterMethod(ITestResult IResults) throws Exception{

		if (IResults.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "TestCase Failed"+IResults.getName());
			String screenshotPath = common.JavaScreenshot();
			logger.log(LogStatus.FAIL,logger.addScreenCapture(screenshotPath));
			
			// or 
//			logger_Fail("TestCase Failed "+IResults.getName());
		}
	}


	public void logger_Pass(String Message) throws Exception{
		logger.log(LogStatus.PASS, Message);
		logger.log(LogStatus.PASS,logger.addScreenCapture(common.JavaScreenshot()));
	}
	public void logger_Fail(String Message) throws Exception{
		logger.log(LogStatus.FAIL, Message);
		logger.log(LogStatus.FAIL,logger.addScreenCapture(common.JavaScreenshot()));
	}

	public void logger_Skip(String Message) throws Exception{
		logger.log(LogStatus.SKIP, Message);
		logger.log(LogStatus.SKIP,logger.addScreenCapture(common.JavaScreenshot()));
	}

	public void logger_Info(String Message) throws Exception{
		logger.log(LogStatus.INFO, Message);
		logger.log(LogStatus.INFO,logger.addScreenCapture(common.JavaScreenshot()));
	}

}


