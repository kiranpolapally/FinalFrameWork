package object_Repo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage {
	
	@FindBy(xpath="//a[.='Projects']")
	private WebElement btn_project;
	public WebElement btn_project(){
		return btn_project;
	}
	
	
	@FindAll({@FindBy(xpath="//input[@class='selenium']")})
	private List<WebElement> drp_gmail;
	public List<WebElement> drp_gmail(){
		return drp_gmail;
	}
	
	
	@FindBys(value={@FindBy(xpath="//input[@class='selenium']")})
	private List<WebElement> drp_fb;
	public List<WebElement> drp_fb(){
		return drp_fb;
	}

}
