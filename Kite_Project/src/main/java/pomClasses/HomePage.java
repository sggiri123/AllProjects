package pomClasses;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uilClasses.Util1;

public class HomePage extends Util1{
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement dashboardText;
	
	@FindBy(xpath="//span[text()='Funds']")
	private WebElement fundText;
	
	@FindBy(xpath="//input[@icon='search']")
	private WebElement stockSearchBox;
	
	@FindBy(xpath="//ul[@class='omnisearch-results']//li/span[1]/span")
	private List<WebElement> searchedStocksList;
	
	@FindBy(xpath="//span[@class='action-buttons']/button[5]")
	private WebElement addStockToWatchListButton;
	
	@FindBy(xpath="//button[@data-balloon='Added']")
	private WebElement addedStockToWatchlistBtn;
	
	@FindBy(xpath="(//div[@class='vddl-list list-flat']/div//span[@class='nice-name'])[1]")
	private WebElement watchListStock;
	
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public boolean checkForHomePage() {
		try {
			explicitWait(driver, dashboardText, 10);
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	
	public void clickOnFundText() {
		fundText.click();
	}
	
	public boolean enterStockNameAndValidate() {
		stockSearchBox.sendKeys("TATAMOTORS");
		for(WebElement k : searchedStocksList) {
			if(k.getText().contains("TATAMOTORS")) {
				
			}
			else {return false;}
		}
		return true;	
	}
	
	
	public boolean clickOnAddBtn() {
		moveToElement(driver, searchedStocksList.get(0));
		explicitWait(driver, addStockToWatchListButton, 1);
		moveToElement(driver, addStockToWatchListButton);
		addStockToWatchListButton.click();
		try {
			explicitWait(driver, addedStockToWatchlistBtn, 5);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	public String checkWatchlistStock() {
		stockSearchBox.sendKeys(Keys.ESCAPE);
		return watchListStock.getText();
	}
	

}
