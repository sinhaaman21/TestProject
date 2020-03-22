package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public  WebDriver driver;
	
	public void openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	
	public void click(By locator)
	{
		try {
			//waitUntilElementVisible(driver.findElement(locator));
			driver.findElement(locator).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeText(By locator,  String data) {
		try {
			//waitUntilElementVisible(driver.findElement(locator));
			driver.findElement(locator).sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void waitUntilElementVisible(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver,
				30);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		
	}
	
	
	
	
	
	
	public void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void comparePrices(Number a, Number b) {
		int c= a.intValue();
		int d= b.intValue();
		if(c>d) {
			
			System.out.println("Price of iphone on flipkart is less than that on amazon!!");
		}
		else if (c<d) {
			System.out.println("Price of iphone on amazon is less than that on flipkart!!");
		}
	}
}
	
