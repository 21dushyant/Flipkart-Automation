package locus.assignment.data.providers;

import org.testng.annotations.DataProvider;

public class MaxFilterDataProvider {

	public static final String MAX_FILTER="2000";
	@DataProvider(name="maxFilterDataProvider")
	public static  Object[][] provideMaxFilterToBeApplied()
	{
		return new Object[][] {{MAX_FILTER}};
	}
	
}
