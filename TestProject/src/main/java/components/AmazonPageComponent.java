package components;

import java.awt.List;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.AmazonObjectRepository;
import Utility.BaseClass;

public class AmazonPageComponent extends BaseClass {
	public Number price;
	AmazonObjectRepository amazonObjRepo = new AmazonObjectRepository();

	

	public void searchForAnItem(String item) {
		try {
			driver.get("https://www.amazon.in/");
			waitUntilElementVisible(driver.findElement(amazonObjRepo.search_txtfield));
			writeText(amazonObjRepo.search_txtfield, item);
			click(amazonObjRepo.search_btn);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public void getPriceOfSearchedItemAmazon(String itemName) {
		try {
			By	locator = By.xpath("//span[contains(text(),'" + itemName + "')]//..//..//..//..//..//..//..//..//..//span[@class='a-price-whole']");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement ele = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(locator));
			String a=ele.getText().trim();
			System.out.println(a);
			String number=a.substring(1, a.length());
			
			String bigNumber = number;
			NumberFormat format = NumberFormat.getInstance(Locale.US);
			    price = 0;
			
				price = format.parse(bigNumber);
				System.out.println(price);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			closeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
