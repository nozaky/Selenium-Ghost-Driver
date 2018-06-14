package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Browser;
import base.MainFunctions;
import utils.GenerateFolders;
import utils.PropertiesManager;

public class CreateScreenshot {

	public static void main(String[] args) {
		//Initialize properties variables
		PropertiesManager properties = new PropertiesManager();
		By txt = By.id("lst-ib");
		
//		String url = properties.url.toString();
		WebDriver driver = null;
		System.out.println(properties.url);
		try {
			GenerateFolders.createFolders();
			Browser b = new Browser();
			driver = b.setBrowser("IE");
			driver.get(properties.url);
			MainFunctions m = new MainFunctions(driver);
//			m.waitAndClick(txt);
			m.overwrite(txt, "Hello");
			b.takeScreenshot(driver,"IE-visible");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println("Closing driver...");
			driver.quit();
			System.out.println("Driver closed");
		}
	}
}
