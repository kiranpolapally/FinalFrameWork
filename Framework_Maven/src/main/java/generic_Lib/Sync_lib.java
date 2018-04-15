package generic_Lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sync_lib {

	public void implicitwait(){
		Driverclass.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public void ExplicitWait(String WbXpath){
		WebDriverWait wait = new WebDriverWait(Driverclass.driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(WbXpath)));
	}
	
	@SuppressWarnings("deprecation")
	public void flunetwait(WebElement element){
		WebDriverWait wait = new WebDriverWait(Driverclass.driver, 40);
		wait.pollingEvery(2, TimeUnit.SECONDS);	
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void Sleep() throws InterruptedException{
		Thread.sleep(3000L);
	}
	
	
	
}
