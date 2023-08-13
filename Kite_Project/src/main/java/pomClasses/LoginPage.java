package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uilClasses.Util1;

public class LoginPage extends Util1{
	
	
	@FindBy(xpath="//input[@id='userid']")
	private WebElement userID;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		System.out.println(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUserID() throws IOException {
		
		userID.sendKeys(getDataFromConfig("userID"));
	}
	
	public void enterPassword() throws IOException {
		
		password.sendKeys(getDataFromConfig("password"));
	}
	
	public void clickOnLoginBtn() {
		
		loginBtn.click();
	}
	
}
