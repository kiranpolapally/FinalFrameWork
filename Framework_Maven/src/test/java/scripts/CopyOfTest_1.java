package scripts;

import generic_Lib.BaseClass;
import org.testng.annotations.Test;
import propertyfiles.Messages;

public class CopyOfTest_1  extends BaseClass{


	@Test
	public void page() throws Exception {

		common.url(Messages.getString("URL"));
		common.Fullscreen();
		wait.Sleep();
		/*
		Sikuli.sikuli_Click("SikuliI_Images\\GO.png");
		Sikuli.sikuli_Click(excel.ExcelRead(1, 1));
		wait.Sleep();
		 */	
		OR.login.btn_project().click();
		//		 logger = reports.startTest("paased");
		logger = reports.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());	 
		logger_Pass("sample code for printing");

	}


}
