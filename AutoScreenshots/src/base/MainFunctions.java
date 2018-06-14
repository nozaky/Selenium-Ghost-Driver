package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainFunctions {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public MainFunctions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	
	public void waitAndClick(By element) {
		System.out.println("Searching for element: "+element.toString());
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Element located");
		driver.findElement(element).click();
	}
	
	public void overwrite(By element, String text) {
		System.out.println("Searching for element: "+element.toString());
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(text);
	}
}
