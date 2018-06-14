package base;

import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PropertiesManager;

public class MainFunctions {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public MainFunctions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	
	/**
	 * Method to click on button or field
	 * @param element = button or field
	 */
	public void waitAndClick(By element) {
		try {
			System.out.println("Searching for element: "+element.toString());
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("Element located");
			driver.findElement(element).click();			
		} catch (Exception e) {
			System.out.println("ERROR: "+e.toString());
		}
	}
	
	/**
	 * Method to write on field
	 * @param element = field
	 * @param text = text to write
	 */
	public void overwrite(By element, String text) {
		try {
			System.out.println("Searching for element: "+element.toString());
			wait.until(ExpectedConditions.elementToBeClickable(element));
			driver.findElement(element).clear();
			driver.findElement(element).sendKeys(text);			
		} catch (Exception e) {
			System.out.println("ERROR: "+e.toString());
		}
	}
	
	public void logReport(String lvl,String desc) {
		try {
			File file = new File(PropertiesManager.screenshotsFolder+"/logError.txt");
			FileWriter fw = new FileWriter(file,true);
			fw.write(lvl+" - "+desc+"\n");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
