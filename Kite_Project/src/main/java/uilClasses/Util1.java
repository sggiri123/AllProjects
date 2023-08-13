package uilClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util1 {
	
	
	public static String getDataFromConfig(String key) throws IOException {
		FileInputStream file = new FileInputStream("Configuration\\config.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value =prop.getProperty(key);
		return value;
	}
	
	
	public static void explicitWait(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static void switchToChildPopup(WebDriver driver) {
		List<String> addressList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(addressList.get(1));
	}
	
	
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	

}
