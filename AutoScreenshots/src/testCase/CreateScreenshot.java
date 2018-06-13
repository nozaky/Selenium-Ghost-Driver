package testCase;

import org.openqa.selenium.WebDriver;

import base.Browser;
import utils.GenerateFolders;
import utils.PropertiesManager;

public class CreateScreenshot {

	public static void main(String[] args) {
		PropertiesManager properties = new PropertiesManager();
		String url = properties.url.toString();
		WebDriver driver = null;
		System.out.println(url);
		try {
			GenerateFolders.createFolders();
			Browser b = new Browser();
			driver = b.setBrowser("FIREFOX");
			driver.get(url);
			b.takeScreenshot(driver,"Firefox");			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println("Closing driver...");
			driver.quit();
			System.out.println("Driver closed");
		}
	}
}
