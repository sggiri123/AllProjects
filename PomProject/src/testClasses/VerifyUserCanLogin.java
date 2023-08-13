package testClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.Base1;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class VerifyUserCanLogin {
	
	WebDriver driver;
	
	LoginPage lp;
	HomePage hp;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		driver = Base1.getDriver(browser);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}
	
	@Test
	public void VerifyUserLogin() {
		lp.enterEmailID();
		lp.enterPassword();
		lp.clickOnLoginBtn();
		boolean isProfileNameVisible = hp.checkProfileNameVisible();
		
		Assert.assertTrue(isProfileNameVisible);
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method Called");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class Called");
		Base1.unloadDriver();
	}
}
