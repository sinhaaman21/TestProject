package components;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.FlipkartObjectRepository;
import Utility.BaseClass;

public class FlipkartPageComponent extends BaseClass {
	FlipkartObjectRepository fobr = new FlipkartObjectRepository();
	public Number price;

	public void closePopUp() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement cross = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(fobr.closeButton));
		cross.click();
	}

	public void searchProduct(String productName) {
		waitUntilElementVisible(driver.findElement(fobr.search_textfield));
		writeText(fobr.search_textfield, productName);
		click(fobr.search_btn);
	}
// Getting the value of the product that has been searched
	public void getProductPrice(String productName) {
		try {
			By  locator = (By.xpath("(//div[contains(text(),'" + productName
					+ "')]//..//..//..//div[contains(@class,'col col-5-12')]//div)[3]"));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}
}
