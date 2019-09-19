package locus.assignment.property.readers.or.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PropertyReader {

	static PropertyReader propertyReader=null;
	static Properties p;
	
	public static PropertyReader getPropertyReaderInstance()
	{
		if(propertyReader==null)
		{
			propertyReader=new PropertyReader();
		}
		
		return propertyReader;
	}
	
	private PropertyReader()
	{
		FileReader reader;
		p=new Properties();  
	    
		try {
			reader = new FileReader("./resources/driver.properties");
			p.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	      
	      
	    
	}
	
	
	public static WebDriver getDriver(String driver)
	{
		if(driver.equals(ConstantClass.CHROME_DRIVER))
		{
			System.setProperty("webdriver.chrome.driver",p.getProperty("ChromeDriver"));
			return new ChromeDriver();
			
		}
		else if(driver.equals(ConstantClass.FIREFOX_DRIVER))
		{
			System.setProperty("webdriver.firefox.marionette",p.getProperty("FireFoxDriver"));
			return new FirefoxDriver();
			
		}
		else
		{
			System.setProperty("webdriver.chrome.driver",p.getProperty("IEDriver"));
			return new InternetExplorerDriver();
				
		}
		
	}
	
}
