package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import com.crm.util.Testutil;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	private Properties Prop;
	
	
	
	
	public TestBase(){
		
		
		try {
			
			 prop =  new Properties();
			 FileInputStream ip = new FileInputStream("C:\\Users\\HQQ098\\eclipse-workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"
					 + "/qa\\\\config\\\\config.properties");
			 Prop.load(ip);
			 	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
			
	}
		
	public static void initialization() {
		String browsername = prop.getProperty("Browser");
		if(browsername.equals("Chrome")) {
			
			System.setProperty("Webdriver.chrome.driver", "C:\\Users\\HQQ098\\Downloads\\chromedriver");
			WebDriver driver = new ChromeDriver();
			
			}
		else if(browsername.equals("FF")) {
			System.setProperty("Webdriver.gecko.driver", "C:\\Users\\HQQ098\\Downloads\\geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
	
	
	
	
	
}
