package Test_Util;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

import TestBase.TestBase;

public class Test_Util extends TestBase{

	public static long implicitlyWait = 20; 
	public static long pageLoadTimeout = 20;

	public static void takeScreenshotAtEndOfTest() throws Exception {
		File scrfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrfile, new File(currentDir + "/screenshots/" + System.currentTimeMillis()+ ".png"));
		}
}