package locus.assignment.data.providers;

import org.testng.annotations.DataProvider;

public class ShoeSizeDataProvider {

	public static final String SHOE_SIZE="9";
	@DataProvider(name="shoeSizeDataProvider")
	public static Object[][] provideShoeSize()
	{
		return new Object[][]{{SHOE_SIZE}};
	}
	
}
