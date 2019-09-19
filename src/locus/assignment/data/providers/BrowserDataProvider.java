package locus.assignment.data.providers;

import org.testng.annotations.DataProvider;

import locus.assignment.property.readers.or.utils.ConstantClass;

public class BrowserDataProvider {

	@DataProvider(name="browserDataProvider")
	public static Object[][] getDrivers()
	{
		return new Object[][] {{ConstantClass.CHROME_DRIVER}};
	}
}
