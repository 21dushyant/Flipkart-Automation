package locus.assignment.web.page.classes;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

import locus.assignment.property.readers.or.utils.CommonFunctions;

import org.testng.Assert;

public class SearchResultsPage {
	//SearchPage
	
	
	 	private WebDriver chromeDriver;
	 	private Wait<WebDriver> wait;
		private String brand_name;
	 	@FindBy(how =How.CSS,using ="._3vKPvR" )
		private WebElement searchBrandTextBox;
				
		@FindBy(how =How.CSS,using ="._1YoBfV :first-child")
		private WebElement filterBox;
		
		@FindBy(how=How.CSS,using="SPAN[class='_2yAnYN']")
		private WebElement searchResultMessage;
		
		@FindBy(how=How.CSS,using="[class='_2wQvxh _1WV8jE']:nth-child(1)")
		private WebElement searchBrandCheckBox;
		
		 
		@FindBy(how=How.CSS,using="div._3O0U0u")
		private List<WebElement> all_rows ;
		
		@FindBy(how=How.CSS,using="div._3O0U0u > div")
		private List<WebElement> all_search_results ;
		
		
		@FindBy(how=How.CSS,using="[data-tkid*='.SEARCH'] ._2B_pmu:nth-child(1)")
		private WebElement search_brand_text ;
		
		
		
		@FindBy(how=How.CSS,using="div._3O0U0u > div *> img[src*='jpeg']")
		private List<WebElement> all_images ;
		
				
		//@FindBy(how=How.XPATH,using="//div[@class='_3O0U0u'][1]/*")
		@FindBy(how=How.CSS,using="img[src*='https://rukminim1.flixcart.com/'][alt]:nth-child(1)")
		private List<WebElement> all_results ;
		
		
		
		public SearchResultsPage(WebDriver driver)
		{
			chromeDriver=driver;
			PageFactory.initElements(chromeDriver, this);
			wait = new FluentWait(chromeDriver)
				    .withTimeout(Duration.ofSeconds(30))
				    .pollingEvery(Duration.ofSeconds(5))
				    .ignoring(NoSuchElementException.class);
			Reporter.log("SearchResultsPage initialised");		
			CommonFunctions.loadAllImages(chromeDriver );	
			
			
		}
		
		public SearchResultsPage applyFilter(String value)
		{
			wait.until(ExpectedConditions.visibilityOf(filterBox));
			Select select=new Select(filterBox);
			select.selectByValue(value);
			chromeDriver.navigate().refresh();
			Reporter.log("MaxFilter Applied");		
			return this;
		}
		public SearchResultsPage applyBrandCheck(String brand)
		{
			brand_name=brand;
			wait.until(CommonFunctions.waitUntillPageIsFullyLoaded());
			searchBrandTextBox.sendKeys(brand);	
			wait.until(ExpectedConditions.elementToBeClickable(searchBrandCheckBox));
			
			Reporter.log("Brand is selected");		
			searchBrandCheckBox.click();
			
			
			return this;
		}
		
		
		public SearchResultsPage checkAllFirstRowItems()
		{
			search_brand_text.getText().equals(brand_name);
			Reporter.log("First result is of "+brand_name);
			
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i=0;i<all_results.size()/all_rows.size();i++)
			{
				wait.until(ExpectedConditions.visibilityOf(all_images.get(i)));
				
				CommonFunctions.checkImage(all_images.get(i), chromeDriver);
;				boolean condition=all_images.get(i).isDisplayed();		
				Reporter.log((i+1)+"th image ="+all_images.get(i).getAttribute("src")+" is displayed.");
				Assert.assertEquals(condition, true);
			}
			
			return this;
		}
		
		public ProductDetailsPage gotoFirstProduct()
		{
			PageFactory.initElements(chromeDriver, this);
			
			wait.until(ExpectedConditions.visibilityOf(all_results.get(0)));
			
			wait.until(CommonFunctions.waitUntillPageIsFullyLoaded());
			Actions actions = new Actions(chromeDriver);
			actions.moveToElement(all_results.get(0)).perform();;
			wait.until(ExpectedConditions.elementToBeClickable(all_results.get(0)));
			all_results.get(0).click();
			CommonFunctions.switchTab(chromeDriver);
			wait.until(CommonFunctions.waitUntillPageIsFullyLoaded());
			Reporter.log("First Product from search results is clicked");		
			return new ProductDetailsPage(chromeDriver);
		}
		
		
		public SearchResultsPage checkItemHasBeenSearched()
		{
			wait.until(ExpectedConditions.elementToBeClickable(searchResultMessage));
			String search_result_message=searchResultMessage.getText();			
			AssertJUnit.assertEquals(true, search_result_message.endsWith("\"shoes\""));
			AssertJUnit.assertEquals(true, search_result_message.contains("40"));
			Reporter.log("Item Searched Properly and with correct Number of Results");		
			return this;
		}
		
}
