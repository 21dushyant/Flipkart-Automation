package locus.assignment.web.page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CheckOutPage {

	
	private WebDriver chromeDriver;
 	private WebDriverWait wait;
	
	
	
	
	@FindBy(how =How.CSS,using ="._2ZvOfP:nth-of-type(1) ._14H79F" )
	private WebElement usernameTextBox;
		
	@FindBy(how =How.CSS,using ="._2SmWvj ._14H79F")
	private WebElement passwordTextBox;

	
	public CheckOutPage()
	{

		Reporter.log("CheckOut Page is Initialised");		
		
	}
	
	public CheckOutPage(WebDriver driver)
	{
		chromeDriver=driver;
		PageFactory.initElements(chromeDriver, this);
		wait=new WebDriverWait(chromeDriver,15);
		Reporter.log("CheckOut Page is Initialised");		
	}
}
