package baseClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base1 {
	
	static WebDriver driver;
	
	//Initializations
	public static WebDriver getDriver(String browser) {
		
		if(driver == null) {
			
			if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Velocity\\Batch 18th June 2022\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\Velocity\\Batch 18th June 2022\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		return driver;
	}
	
	
	public static void unloadDriver() {
		driver = null;
	}
	
	

}
