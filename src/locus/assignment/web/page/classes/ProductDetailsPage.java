package locus.assignment.web.page.classes;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.utils.URIUtils;
import org.apache.http.protocol.UriPatternMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

import locus.assignment.property.readers.or.utils.CommonFunctions;


public class ProductDetailsPage {

	private WebDriver chromeDriver;
 	private FluentWait wait;
	
	//Product Details Page
	
 	
 		private final int IFRAME_PIC_NO=3;
 		@FindBy(how=How.CSS,using="[class='_3togXc _3wp706']")
		private WebElement product_main_image;
 		
 		@FindBy(how=How.CSS,using="ul[class='LzhdeS'] > li :nth-child(1)")
		private List<WebElement> all_product_images;
 		
 		@FindBy(how=How.CSS,using="[class='fUBI-_'] > li[id*='size']")
		private List<WebElement> all_product_sizes;
 		
 				
 		@FindBy(how=How.CSS,using="div[class='_1vC4OE _3qQ9m1']")
 		private WebElement product_price;
	
 		
 		
 		
 		@FindBy(how=How.CSS,using="button[class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c'][type='button']")
		private WebElement buy_now_button ;
		
		
		@FindBy(how=How.CSS,using="button[class='_2AkmmA _3-iCOr wvj5kH']")
		private WebElement notify_me_button ;
		
		
		public ProductDetailsPage(WebDriver driver)
		{
			chromeDriver=driver;
			PageFactory.initElements(chromeDriver, this);
			wait = new FluentWait(chromeDriver)
				    .withTimeout(Duration.ofSeconds(30))
				    .pollingEvery(Duration.ofSeconds(5))
				    .ignoring(NoSuchElementException.class);
			Reporter.log("ProductDetailsPage initialised");		
			CommonFunctions.loadAllImages(chromeDriver );	    
		}
		
		public ProductDetailsPage checkProductMainImage()
		{
			boolean flag= CommonFunctions.checkImage(product_main_image, chromeDriver);
			if(flag)
				Reporter.log("Image displayed.");
			else
				Reporter.log("Image not displayed.");
			return this;
		}
		
		public ProductDetailsPage checkProductAllImages()
		{
			for(int i=1;i<all_product_images.size();i+=2) {
				if(i!=IFRAME_PIC_NO) {
			Actions actions= new Actions(chromeDriver);
			actions.moveToElement(all_product_images.get(i)).build().perform();;;
			wait.until(ExpectedConditions.visibilityOf(product_main_image));				
			try {
				
					Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			boolean flag= CommonFunctions.checkImage(product_main_image, chromeDriver);
			if(flag)
				Reporter.log("Image displayed.");
			else
				Reporter.log("Image not displayed.");
				}
				}
			return this;
		}
		
		public String parseUrl(String string)
		{
			Reporter.log(string);
			String url = string.substring(string.indexOf("http"), string.indexOf("\")"));
		    System.out.println(url);
			return url;
		}
		
		public ProductDetailsPage checkProductAllSizes()
		{
			for(int i=0;i<all_product_sizes.size();i++) {
				
				if(all_product_sizes.get(i).getText().equals(i+6+""))
				{
					Reporter.log("Size "+(i+6)+" displayed.");
				}
				
				}
			return this;
			
		}
		
		public ProductDetailsPage checkProductPrize()
		{
			if(product_price!=null)
			{
				Reporter.log("Price "+product_price.getText()+" displayed.");
				
			}
			return this;
		}
		
		
		public ProductDetailsPage applyShoeSize(String shoeSize)
		{
			
			int index=0;
			for (;index<all_product_sizes.size();index++)
			{
				if(shoeSize.equals(all_product_sizes.get(index).getText()))
					break;
			}
			
			
			
			wait.until(ExpectedConditions.visibilityOf(all_product_sizes.get(index)));
			wait.until(ExpectedConditions.elementToBeClickable(all_product_sizes.get(index)));
			all_product_sizes.get(index).click();
			Reporter.log("Product size is Clicked");		
			
			return this;
		}
		
		
		public CheckOutPage buyNow()
		{
			CommonFunctions.waitUntillPageIsFullyLoaded();
			
			try {
			Actions actions= new Actions(chromeDriver);
			wait.until(ExpectedConditions.elementToBeClickable(buy_now_button));
			
			actions.moveToElement(buy_now_button).perform();;
			buy_now_button.click();
			wait.until(CommonFunctions.waitUntillPageIsFullyLoaded());
			Reporter.log("CheckOut for Product Started");		
			return new CheckOutPage(chromeDriver);
			}
			catch(NoSuchElementException e)
			{
				Actions actions= new Actions(chromeDriver);
				wait.until(ExpectedConditions.elementToBeClickable(notify_me_button));
				
				actions.moveToElement(notify_me_button).perform();;
				notify_me_button.click();
				wait.until(CommonFunctions.waitUntillPageIsFullyLoaded());
				Reporter.log("notify_me_button for Product Started"); 
			
			}
				return new CheckOutPage();
		}
		
		
		
		
		
		
		
		
		
}
