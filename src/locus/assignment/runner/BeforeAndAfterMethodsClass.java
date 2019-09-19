package locus.assignment.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import locus.assignment.property.readers.or.utils.CommonFunctions;
import locus.assignment.property.readers.or.utils.ConstantClass;
import locus.assignment.property.readers.or.utils.PropertyReader;

public class BeforeAndAfterMethodsClass {

	private WebDriver driver;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(String driverString) {
		
		driver=PropertyReader.getPropertyReaderInstance().getDriver(driverString);

		
	}
	


	
}
