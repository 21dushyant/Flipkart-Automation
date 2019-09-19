package locus.assignment.web.page.classes;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import locus.assignment.property.readers.or.utils.CommonFunctions;
import locus.assignment.property.readers.or.utils.ConstantClass;
import locus.assignment.property.readers.or.utils.PropertyReader;

public class HomePage
{
	
	@FindBy(how =How.CSS,using="._29YdH8")
	private WebElement closeButton;
	@FindBy(how =How.CSS,using="[class]._1va75j:nth-of-type(1)>*:first-child")
	private WebElement searchDropdownFirstElement;
	@FindBy(how =How.CSS,using="input[name='q'][type='text']")
	private WebElement searchBox;
	@FindBy(how =How.CSS,using ="button.vh79eN[type=submit]" )
	private WebElement searchButton;
	
	WebDriver chromeDriver;
	FluentWait wait;
	
	
	
	
	
	public HomePage(WebDriver driver)
	{
		chromeDriver=driver;		
		wait=new FluentWait(chromeDriver)
			    .withTimeout(Duration.ofSeconds(10))
			    .pollingEvery(Duration.ofSeconds(5))
			    .ignoring(NoSuchElementException.class);
		PageFactory.initElements(chromeDriver, this);
		Reporter.log("HomePage Initialized");
		
	}
	
	public HomePage gotoHomePageUrl()
	{
		chromeDriver.manage().window().maximize();;
		chromeDriver.get(ConstantClass.BASE_URL);
		Reporter.log("HomePage URL is reached");
		return this;
	}
	
	public HomePage closeLoginPopUp()
	{
		closeButton.click();
		Reporter.log("LoginPopup Closed");
		
		return this;
	}
	
	public HomePage searchItem(String item)
	{
		searchBox.sendKeys(item);
		Reporter.log("Search Item Entered for Searching");		
		return this;
	}
	
	public SearchResultsPage selectFirstItemFromDropDown()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(searchDropdownFirstElement));
		searchDropdownFirstElement.click();
		wait.until(CommonFunctions.waitUntillPageIsFullyLoaded());
		Reporter.log("First Search Item is selected from drop down");		
		return new SearchResultsPage(chromeDriver);
	}
	
	
	
}
