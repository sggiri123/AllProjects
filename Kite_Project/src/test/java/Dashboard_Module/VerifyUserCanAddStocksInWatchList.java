package Dashboard_Module;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass1;
import pomClasses.FundPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class VerifyUserCanAddStocksInWatchList {
	
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	FundPage fp;
	
	@BeforeClass
	public void beforeClass(){
		driver = BaseClass1.getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}
	
	
	@Test(priority=1)
	public void VerifyUserCanLogin() throws IOException {
		lp.enterUserID();
		lp.enterPassword();
		lp.clickOnLoginBtn();
		Assert.assertTrue(hp.checkForHomePage());
	}
	
	
	@Test(priority=2)
	public void VerifyUserCanSearchStocks() throws IOException {
		Assert.assertTrue(hp.enterStockNameAndValidate());
	}
	
	@Test(priority=3)
	public void VerifyUserCanClickOnAddBtn() throws IOException {

		Assert.assertTrue(hp.clickOnAddBtn());
	}
	
	
	@Test(priority=4)
	public void VerifywatchlistAddedStock() throws IOException {

		Assert.assertEquals(hp.checkWatchlistStock(), "TATAMOTORS");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	
	@AfterClass
	public void afterClass() {
		
	}

}
