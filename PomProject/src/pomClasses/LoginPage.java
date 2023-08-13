package pomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.Util1;

public class LoginPage extends Util1{
	
	WebDriver driver;
	
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement emailID;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	
	public void enterEmailID() {
		emailID.sendKeys("akshaynarhare1541@gmail.com");
	}
	
	public void enterPassword() {
		password.sendKeys("Akshay123");
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	

}
