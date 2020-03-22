package testScript;



import org.testng.annotations.Test;

import components.AmazonPageComponent;
import components.FlipkartPageComponent;

public class PriceCompareScript {
static AmazonPageComponent amazon=new AmazonPageComponent();
static FlipkartPageComponent flipkart= new FlipkartPageComponent();
//amazon url
static String url1="https://www.amazon.in/";
static String url2="https://www.flipkart.com/";
static String itemName="iPhone XR (64GB) - Yellow";
static String productName="iPhone XR (Yellow, 64 GB)";
 @Test
 public static void comparePrice(){
	
	amazon.openBrowser(url1);
	 amazon.searchForAnItem(itemName);
	 amazon.getPriceOfSearchedItemAmazon(itemName);
	 flipkart.openBrowser(url2);
	 flipkart.closePopUp();
	 flipkart.searchProduct(productName);
	 flipkart.getProductPrice(productName);
	 amazon.comparePrices(amazon.price, flipkart.price);
	 flipkart.closeBrowser();
	
}


}