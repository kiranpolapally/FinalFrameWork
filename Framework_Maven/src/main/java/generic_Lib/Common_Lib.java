package generic_Lib;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class Common_Lib {


	public void Fullscreen(){
		Driverclass.driver.manage().window().maximize();
	}

	public void close(){
		Driverclass.driver.close();
	}

	public void Quit(){
		Driverclass.driver.quit();
	}

	//sendkeys

	public String Sendkeys(String TextXpath, String Value){

		Driverclass.driver.findElement(By.xpath(TextXpath)).sendKeys(Value);
		return Value;
	}


	public String timestamp(){

		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("hh_mm_ss k MMM_dd_YYYY");
		String k = s.format(d);
		return k;
	}

	public void DropDown_VisibleText(String Xpath, String SelectByVisibleText){

		Select Sel = new Select(Driverclass.driver.findElement(By.xpath(Xpath)));
		Sel.selectByVisibleText(SelectByVisibleText);
	}

	public void url(String URL){
		Driverclass.driver.get(URL);
	}


	public void BrowserCalling(String Browser){

		switch (Browser) {
		case "IE":
		case "ie":
		case "Ie":
			System.setProperty("webdriver.ie.driver", "Browser//ieserver.exe");
			Driverclass.driver = new InternetExplorerDriver();
			break;

		case "chrome":
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "Browser/chromedriver.exe");
			Driverclass.driver = new ChromeDriver();
			break;

		default:
			break;
		}

	}

	public String JavaScreenshot() throws Exception{
		BufferedImage  image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		String path = "Screenshots//"+timestamp()+"_Java.jpg";
		ImageIO.write(image, "png", new File(path));
		return path;
	}

	public String SeleniumScreenshot() throws IOException{
		File scr = ((TakesScreenshot)Driverclass.driver).getScreenshotAs(OutputType.FILE);
		String path = "Screenshots//"+timestamp()+"_Selenium.jpg";
		FileUtils.copyFile(scr, new File(path));
		return path;
	}

}
