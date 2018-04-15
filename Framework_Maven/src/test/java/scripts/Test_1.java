package scripts;

import generic_Lib.BaseClass;
import java.io.File;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test_1 extends BaseClass {
	
  @Test
  public void f() {
	  
	  reports = new ExtentReports("ExtentReports//"+getClass().getSimpleName()+".html", true);
	  reports.loadConfig(new File(".\\Framework_Maven\\Extent_config.xml"));
	  
	  logger = reports.startTest("passTest");
	  logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	  logger.log(LogStatus.INFO, "Test Case Passed is passTest");
	  logger.log(LogStatus.SKIP, "Test Case Passed is passTest");
	  logger.log(LogStatus.FATAL, "Test Case Passed is passTest");
	  logger.log(LogStatus.ERROR, "Test Case Passed is passTest");
	  logger.log(LogStatus.FAIL, "Test Case Passed is passTest");
	  
	  
	  //After Test
	  reports.endTest(logger);
	  reports.flush();
//	  System.out.println("mssages "+Messages.getString("Name")); //$NON-NLS-1$
	}
	  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
