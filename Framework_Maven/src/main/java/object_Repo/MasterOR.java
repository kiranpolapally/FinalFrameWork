package object_Repo;

import generic_Lib.Driverclass;
import org.openqa.selenium.support.PageFactory;

public class MasterOR {

	public LoginPage login = null;
	
	
	
	

	public MasterOR(){

		login = PageFactory.initElements(Driverclass.driver, LoginPage.class);
	}


}
