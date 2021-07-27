package TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.TicTacToePage;
import TestBase.TestBase;
import Test_Util.Test_Util;


public class ticTacToeTest extends TestBase{

	static TicTacToePage tttp; 
	static SoftAssert softAssert;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public ticTacToeTest() 
	{
		super();
	}


	@BeforeMethod
	public static void setUp() 
	{
		initBrowser();
		softAssert = new SoftAssert();
		tttp = new TicTacToePage();

		driver.switchTo().frame("result");
	}



	//1.)
	@Test  (priority = 1, enabled = true)
	
	public static void getTitle() 
	{
		softAssert.assertEquals("QA Interview Assignment",tttp.getPageTitle());
	}


	//2.)This test should fail
	@Test  (priority = 2, enabled = true)
	
	public static void playUntilDrawNoDisplayTest() throws IOException 
	{
		tttp.playUntilDraw();
		tttp.endGameMessage.contains("Draw!");

	}


	
	@Test  (priority = 3, enabled = false)
	public static void switchWinnerTest() 
	{
		tttp.switchWinner();
		String congratsDisplay = driver.findElement(By.xpath("//div[@id='endgame']")).getText();
		softAssert.assertEquals(congratsDisplay, "Congratulations player X! You've won. Refresh to play again!");
	}


	
	@Test (priority = 4, enabled = false)
	public static void clickPlayMultipleTimesTest() throws InterruptedException 
	{
		tttp.clickPlayMultipleTimes();
		WebElement lastCellElement = driver.findElement(By.xpath("//body/table[@id='table']/tr[12]/td[3]"));
		softAssert.assertEquals(lastCellElement,lastCellElement);
	}
	

	@AfterMethod
	public static void tearDown() 
	{
		driver.quit();
	}

}
