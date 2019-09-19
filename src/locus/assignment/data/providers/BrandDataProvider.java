package locus.assignment.data.providers;

import org.testng.annotations.DataProvider;

public class BrandDataProvider {

	public static final String BRAND_NAME="Puma";
	@DataProvider(name="brandDataProvider")
	public static Object[][] provideBrandData()
	{
		return new Object[][] {{BRAND_NAME}};
	}
}
