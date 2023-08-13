package testClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClasses.Base1;
import graphql.Assert;
import pomClasses.HomePage;
import pomClasses.ProfilePage;

public class VerifyUserCanAddAddress {
	
	WebDriver driver;
	
	HomePage hp;
	ProfilePage pp;
	
	int oldAddressCount;
	int currentAddressCount;
	
	boolean isAddressUpdated = true;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		driver = Base1.getDriver(browser);
	}

	@BeforeMethod
	public void beforeMethod() {
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
	}
	
	@Test(priority=1)
	public void verifyUserCanGoToProfilePage() {
		if(hp.clickOnMyProfile()) {
			System.out.println("Test is passed");
		}else {
			System.out.println("Test is failed");
		}
		
		pp.clickOnManageAddress();
		
		oldAddressCount = pp.getAddressCount();
		
		pp.clickOnAddNewAddressText();
	}
	
	@DataProvider(name="testData")
	public String[][] getData(){
		String[][] uData = {{"Anvi","8956235623","411033","near dmart", "Shivaji chowk, near busstand, pune"}, {"Sai","7845125623","411017","deccan chowk","Gandhi chowk, near mall, pune"}};
		return uData;
	}
	
	
	@Test(priority=2,dataProvider="testData")
	public void verifyUserCanAddNewAddress(String name, String MobNumber, String pincode, String locality, String detailAdd) {
	
		List<String> addressDataList = new ArrayList<>(Arrays.asList(name, MobNumber,pincode,locality,detailAdd));
		
		pp.addAddress(addressDataList);
		
		currentAddressCount = pp.getAddressCount();
		
		if(oldAddressCount == currentAddressCount) {
			isAddressUpdated = false;
		}
		
		Assert.assertTrue(isAddressUpdated);
		
	}
}
