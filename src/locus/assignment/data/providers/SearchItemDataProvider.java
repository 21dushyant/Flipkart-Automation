package locus.assignment.data.providers;

import org.testng.annotations.DataProvider;

public class SearchItemDataProvider {

	public static final String SEARCH_ITEM="shoes";
	@DataProvider(name="searchItemDataProvider")
	public static Object[][] provideItemToBeSearched()
	{
		return new Object[][]{{SEARCH_ITEM}};
	}
	
	
}
