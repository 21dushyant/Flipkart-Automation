package locus.assignment.runner;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import locus.assignment.web.page.classes.CheckOutPage;
import locus.assignment.web.page.classes.HomePage;
import locus.assignment.web.page.classes.ProductDetailsPage;
import locus.assignment.web.page.classes.SearchResultsPage;



public class TestSuiteRunner extends BeforeAndAfterMethodsClass{

	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private ProductDetailsPage productDetailsPage;
	private CheckOutPage checkOutPage;

	
	
	
	@Test(priority=0,dataProvider="browserDataProvider",
			dataProviderClass=locus.assignment.data.providers.BrowserDataProvider.class)
	public void navigateToHomeAndClosePopUp(String driver)
	{
		setDriver(driver);
		homePage=new HomePage(getDriver());
		Assert.assertNotNull(homePage);
		homePage.gotoHomePageUrl();
		homePage.closeLoginPopUp();
		
	}
	
	
	@Test(priority=1,dependsOnMethods= {"navigateToHomeAndClosePopUp"},
			dataProvider="searchItemDataProvider",
			dataProviderClass=locus.assignment.data.providers.SearchItemDataProvider.class)
	public void searchItemOnHomePage(String item)
	{
		homePage.searchItem(item);
		searchResultsPage=homePage.selectFirstItemFromDropDown();
		Assert.assertNotNull(searchResultsPage);
		searchResultsPage.checkItemHasBeenSearched();
	}
	
	@Test(priority=2,dependsOnMethods= {"searchItemOnHomePage"},
			dataProvider= "maxFilterDataProvider",
			dataProviderClass=locus.assignment.data.providers.MaxFilterDataProvider.class)
	public void applyFilterOnSearchResultsPage(String value)
	{
		searchResultsPage.applyFilter(value);
	}
	
	@Test(priority=3,dependsOnMethods= {"applyFilterOnSearchResultsPage"},
			dataProvider= "brandDataProvider",
			dataProviderClass=locus.assignment.data.providers.BrandDataProvider.class)
	public void selectBrandOnSearchResultsPage(String brand)
	{
		searchResultsPage.applyBrandCheck(brand);
		searchResultsPage.checkAllFirstRowItems();
		productDetailsPage=searchResultsPage.gotoFirstProduct();
		Assert.assertNotNull(productDetailsPage);
	}
	
	@Test(priority=4,dependsOnMethods= {"selectBrandOnSearchResultsPage"},
			dataProvider= "shoeSizeDataProvider",
			dataProviderClass=locus.assignment.data.providers.ShoeSizeDataProvider.class)
	public void selectProductAndSelectProductDetailsPageAndBuyProduct(String value)
	{
		productDetailsPage.checkProductMainImage();
		productDetailsPage.checkProductPrize();				
		productDetailsPage.checkProductAllImages();
		productDetailsPage.checkProductAllSizes();
		productDetailsPage.applyShoeSize(value);
		checkOutPage=productDetailsPage.buyNow();
		
		Assert.assertNotNull(checkOutPage);
	}
	 	
}
