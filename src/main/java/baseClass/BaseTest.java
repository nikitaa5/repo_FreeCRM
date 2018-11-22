package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.TestUtil;
import util.WebEventListener;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public BaseTest() {
		//reading properties inside try and catch block
		File filepath = new File("E:\\DEMO_WORKSPACE\\com.freecrm\\src\\main\\java\\config\\ConfigfreeCrm.properties");
	      FileInputStream ipStream;
	    try {
	        ipStream = new FileInputStream(filepath);
	          //call properties
	          prop = new Properties();
	          prop.load(ipStream);
	          //Report Initailization
	   //       extentReports = ExtentManager.getInstance();
	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }  }
	
	public static void initialization() {
	String browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "E:\\DEMO_WORKSPACE\\com.freecrm\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "E:\\DEMO_WORKSPACE\\com.freecrm\\BrowserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}else {
		System.out.println("Browser not specified");
	}
	
	e_driver = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver; 
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	}
}
