package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Browser;
import base.MainFunctions;
import utils.GenerateFolders;
import utils.PropertiesManager;
import utils.ReadDataFile;

public class CreateScreenshot {

	public static void main(String[] args) {
		//Initialize properties variables
		PropertiesManager properties = new PropertiesManager();
		ReadDataFile rdf = new ReadDataFile();
		String [] data = rdf.readFile();
		for (int i = 0; i < data.length; i++) {
			System.out.println("Data --> "+data[i]);
		}
		By lblSearch = By.id("lst-ib");

//		String url = properties.url.toString();
		WebDriver driver = null;
//		System.out.println(properties.url);
		try {
			GenerateFolders.createFolders();
			Browser b = new Browser();
			driver = b.setBrowser(PropertiesManager.browser);
			driver.get(PropertiesManager.urlCustomer);
			MainFunctions m = new MainFunctions(driver);
//			m.waitAndClick(lblSearch);
			m.overwrite(lblSearch, "Hola");
			b.takeScreenshot(driver,"Captura-1");
			m.logReport("ERROR", "Element not clickable");
			m.logReport("ERROR", "Element not clickable 2");
			m.logReport("ERROR", "Element not clickable 3");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println("Closing driver...");
			driver.quit();
			System.out.println("Driver closed");
		}
	}
}
