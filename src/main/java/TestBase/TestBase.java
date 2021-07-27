package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import Test_Util.Test_Util;



public class TestBase {

	static 	Properties prop;
	static FileInputStream fis; 
	protected static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;


	public TestBase() {

		try {
			prop = new Properties();
			fis = new FileInputStream("C:\\Users\\jacos\\eclipse-workspace1234\\Calendly_TicTacToe_TakeHome\\src\\main\\java\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initBrowser() {
		String BrowserName = prop.getProperty("browser");

		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jacos\\eclipse-workspace1234\\My_POM\\webdrivers\\chromedriver.exe");
			  driver = new ChromeDriver();
			
		}
		else if(BrowserName.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\jacos\\eclipse-workspace1234\\ShettyPractice\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Test_Util.implicitlyWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Test_Util.pageLoadTimeout, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	
	}





}
