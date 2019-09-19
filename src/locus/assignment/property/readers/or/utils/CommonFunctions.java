package locus.assignment.property.readers.or.utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CommonFunctions {

		
	public static ExpectedCondition<Boolean> waitUntillPageIsFullyLoaded()
	{
		return new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return ((JavascriptExecutor)input).executeScript("return document.readyState").equals("complete");
			}};

	}
	
	
	public static void loadAllImages(WebDriver driver )
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Object result = jse.executeScript("return document.readyState;");
		if(result.equals("complete")) {
		    result = jse.executeScript("return document.images.length");
		    int imagesCount = Integer.parseInt(result.toString());
		    boolean allLoaded = false;
		    while(!allLoaded) {
		        int count = 0;
		        for(int i=0;i<imagesCount;i++) {
		        	
		        	result = jse.executeScript("return document.images["+i+"].complete;");
		        	boolean loaded = (Boolean) result;
		            if(loaded) count++;
		            
		            
		        }
		        if(count == imagesCount) {
		            break;
		        } else {
		        }
		    }
		}
	
	}
	
	
	public static boolean checkImage(WebElement imageFile,WebDriver driver) {
		    
	        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", imageFile);
	        if (!ImagePresent)
	        {
	            return false;
	        	
	        }
	        else
	        {
	        	return true;
	        	
	        }
		}
	
	
	public static void switchTab(WebDriver driver)
	{
		String MainWindow=driver.getWindowHandle();		
		
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();
		
		i1.next();
		driver.switchTo().window(i1.next());
		
	}
}
