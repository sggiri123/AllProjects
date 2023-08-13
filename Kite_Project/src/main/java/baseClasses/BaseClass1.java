package baseClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	
	
	
	public static WebDriver getDriver() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://kite.zerodha.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}

}
