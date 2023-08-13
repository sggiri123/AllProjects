package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import uilClasses.Util1;

public class FundPage extends Util1{
	
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Add funds ']")
	private WebElement addFundBtn;
	
	@FindBy(xpath="//h1[text()='Deposit funds']")
	private WebElement depositeFundText;
	
	@FindBy(xpath="//input[@id='addfunds_amount']")
	private WebElement addDepositeAmountField;
	
	@FindBy(xpath="//select[@id='segment_select']")
	private WebElement selectSegmentDropDown;
	
	@FindBy(xpath="//select[@id='account_select']")
	private WebElement selectAccountDropDown;
	
	@FindBy(xpath="//input[@id='addfunds_vpa']")
	private WebElement upiField;
	
	@FindBy(xpath="//button[@id='addfunds_submit']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//p[text()='Click on the notification received on your UPI App & enter your UPI PIN']")
	private WebElement depositeNotificationText;
	
	
	public FundPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public boolean checkForFundWindow() {
		try {
			explicitWait(driver, addFundBtn, 5);
		}catch(Exception e) {
			return false;
		}
		return true;
		
	}
	
	public void clickOnAddFundBtn() {
		addFundBtn.click();
	}
	
	public boolean checkForDepositeFundWindow() {
		switchToChildPopup(driver);
		try {
			explicitWait(driver, depositeFundText, 5);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	public void enterDepositeAmount() {
		addDepositeAmountField.sendKeys("10");
	}
	
	public void selectSegment() {
		Select sel = new Select(selectSegmentDropDown);
		sel.selectByIndex(0);
	}
	
	public void selectBankAccount() {
		Select sel = new Select(selectAccountDropDown);
		sel.selectByIndex(0);
	}
	
	public void EnterUPI() {
		upiField.clear();
		upiField.sendKeys("9673743951@ybl");
	}
	
	public void clickOnComtinueBtn() {
		continueBtn.click();
	}
	
	public boolean checkForTransitionWindow() {
		switchToChildPopup(driver);
		try {
			explicitWait(driver, depositeNotificationText, 5);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	

}
