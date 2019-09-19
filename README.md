# Flipkart-Automation
******************************************************************LOCUS ASSIGNMENT README FILE******************************************************************
Technologies and Frameworks used : JAVA, Selenium, TestNG
Tools used : Eclipse
Repository handler : Maven
 
**************************************************************************DESCRIPTION********************************************************************************************


THE ASSIGNMENT HAS BEEN MADE FOLLOWING POM(PAGE OBJECT MODEL) WHERE I HAVE USED 4 PAGES(PAGE CLASSES) NAMELY
1. PAGE CLASSES
PACKAGE: locus.assignment.web.page.classes
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	SL NO   /////////  PAGE CLASSES				/////////      DESCRIPTION
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	1.		/////////	HomePage				///////// 	THE STARTING PAGE WHEN WE SEARCH FLIPKART.COM IN BROWSER								////////////
/////////	2.		/////////	SearchResultsPage		///////// 	AFTER SEARCHING SHOES IN HOMEPAGE WE NAVIGATE TO THIS PAGE								////////////
/////////	3.		/////////	ProductDetailsPage		///////// 	AFTER APPLYING FILTER AND SELECTING BRAND ON SearchResultsPage WE NAVIGATE TO THIS PAGE	////////////
/////////	4.		/////////	CheckOutPage			///////// 	AFTER CLICKING ON BUY NOW OOPTIOON ON PROODUCT DETAILS PAGE CheckOutPage				////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

2. DATA PROVIDERS USED 
PACKAGE : locus.assignment.data.providers
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	SL NO   /////////  DATA PROVIDER CLASSES	/////////      DESCRIPTION
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	1.		/////////	BrandDataProvider		///////// 	THIS DATA PROVIDER PROVIDES THE BRAND "Puma" TO BE CHECKED ON SearchResultsPage			////////////
/////////	2.		/////////	BrowserDataProvider		///////// 	THIS DATA PROVIDER PROVIDES THE BROWSER DRIVER USING WHICH TESTS WILL BE EXECUTED		////////////
/////////	3.		/////////	MaxFilterDataProvider	///////// 	THIS DATA PROVIDER PROVIDES THE MAX VALUE "RS. 2000" TO BE SELECTED ON SearchResultsPage////////////
/////////	4.		/////////	SearchItemDataProvider	///////// 	THIS DATA PROVIDER PROVIDES THE ITEM "shoes" TO BE SEARCHED ON HomePage					////////////
/////////	5.		/////////	ShoeSizeDataProvider	///////// 	THIS DATA PROVIDER PROVIDES THE SHOE SIZE "9" TO BE SELECTED ON ProductDetailsPage		////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

3. LISTENERS USED
PACKAGE : locus.assignment.listeners
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	SL NO   /////////   LISTENER CLASS			/////////      DESCRIPTION
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	1.		/////////	TestListenerClass		///////// 	LOGS PROPER MESSAGES IN REPORT OUTPUT													////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


4. UTILITY AND READERS USED
PACKAGE : locus.assignment.property.readers.or.utils
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	SL NO   /////////  DATA PROVIDER CLASSES	/////////      DESCRIPTION
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	1.		/////////	CommonFunctions			///////// 	INCLUDES COMMON FUNCTIONALITIES LIKE softAssert,waitUntillPageIsFullyLoaded,loadAllImages,checkImage,switchTab			////////////
/////////	2.		/////////	ConstantClass			///////// 	DRIVER AND BASE URL COONSTANTS															////////////
/////////	3.		/////////	PropertyReader			///////// 	READING LOCATION OF DRIVERS.EXE FILES													////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


5. PROPERTY FILE : LOCATION/PATH OF DRIVERS.EXE FILES	
FOLDER: resources
FILENAME: DRIVER.PROPERTIES

6. DRIVERS: BROWSERS DRIVERS.EXE FILES	
FOLDER: drivers

7. TEST SUITE RUNNER CLASS
PACKAGE : locus.assignment.runner
CLASS: TestSuiteRunner
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	SL NO   /////////       METHODS	(TESTS)										/////////      DESCRIPTION
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////	1.		/////////	navigateToHomeAndClosePopUp								///////// 	Navigates To Home Page And Close Login Pop Up							////////////
/////////	2.		/////////	searchItemOnHomePage									///////// 	Searchs Item "shoes" On Home Page		////////////
/////////	3.		/////////	applyFilterOnSearchResultsPage							///////// 	Applies Rs. 2000 Filter On SearchResultsPage////////////
/////////	4.		/////////	selectBrandOnSearchResultsPage							///////// 	Selects Brand On Search Results Page					////////////
/////////	5.		/////////	selectProductAndSelectProductDetailsPageAndBuyProduct	///////// 	Selects Product And Select Product Details Page And Buys Product		////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*******************************************************************************************************************************************

ProjectFlow
			    search shoes						            apply filter & select brand							             select shoe size(verify display of prizes, shoes sizes etc) 
HomePage------------------->SearchResultsPage---------------------------------->ProductDetailsPage------------------------------------------------------------>CheckOutPage		



******************************************************************************************************************************************
Importing the zip file 
1. Click File…Import… from the Eclipse main menu
2. Expand General, select Existing Projects into Workspace, and click Next
3. Make sure that Select Archive File is checked and browse for zip file
4. Click Finish
5. You should now see the new project in Package Explorer.
**********************************************************************************************************************************************************

Running the project
1. After importing the project in Eclipse
2. Go to the testng.xml file and right click
3. Then select run as TestNG Suite
*************************************************************************************************************************************






