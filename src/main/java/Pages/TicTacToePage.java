package Pages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import TestBase.TestBase;

public class TicTacToePage extends TestBase {


	static List<WebElement> clickBoxElements;
	static List<WebElement> clickBoxes;
	public static String endGameMessage;

	@FindBy(xpath="//*[@id='number']")
	static WebElement EnterNumberToPlayEditField;

	@FindBy(xpath="//*[@id='start']")
	static WebElement PlayButton;

	@FindBy(xpath="//*[@id='table']/tr/td")
	static WebElement TicTacToeTable;

	@FindBy(xpath="//div[@id='endgame']") 
	static WebElement EndGameTxt;

	@FindBy(xpath="//button[@class='PenEditorFooterAd_closeButton-3LA4G']")
	static WebElement adBtn;



	public TicTacToePage() {
		PageFactory.initElements(driver, this);
	}


	public static String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void playUntilDraw() {
		EnterNumberToPlayEditField.sendKeys("3");
		PlayButton.click();

		driver.findElement(By.xpath("//*[@id='table']/tr[1]/td[1]")).click();
		driver.findElement(By.xpath("//*[@id='table']/tr[1]/td[2]")).click();
		driver.findElement(By.xpath("//*[@id='table']/tr[1]/td[3]")).click();
		driver.findElement(By.xpath("//*[@id='table']/tr[2]/td[2]")).click();
		driver.findElement(By.xpath("//*[@id='table']/tr[2]/td[1]")).click();
		driver.findElement(By.xpath("//*[@id='table']/tr[2]/td[3]")).click();
		driver.findElement(By.xpath("//*[@id='table']/tr[3]/td[2]")).click();
		driver.findElement(By.xpath("//*[@id='table']/tr[3]/td[1]")).click();
		driver.findElement(By.xpath("//*[@id='table']/tr[3]/td[3]")).click();

	}


	public static void XwinsbutOwinsDisplayed()  {

		EnterNumberToPlayEditField.sendKeys("3");
		
		PlayButton.click();

		clickBoxes = driver.findElements(By.xpath("//*[@id='table']/tr/td"));

		clickBoxElements = clickBoxes.stream().limit(7).collect(Collectors.toList());

		clickBoxElements.forEach(s->s.click());

	}

	//Winner changes after they win 
	public static void switchWinner() {

		EnterNumberToPlayEditField.sendKeys("3");
		PlayButton.click();

		clickBoxes = driver.findElements(By.xpath("//*[@id='table']/tr/td"));

		clickBoxElements = clickBoxes.stream().limit(8).collect(Collectors.toList());

		clickBoxElements.forEach(s->s.click());
	}



	//clicking play multiple times 

	public static void clickPlayMultipleTimes() throws InterruptedException {
		EnterNumberToPlayEditField.sendKeys("3");
		PlayButton.click();

		for(int i =0; i<3; i++) {
			driver.findElement(By.xpath("//*[@id='start']")).click();
		}

	}



}
