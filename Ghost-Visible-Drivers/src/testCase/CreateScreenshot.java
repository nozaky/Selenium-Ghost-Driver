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
		// Initialize properties variables
		PropertiesManager properties = new PropertiesManager();
		properties.readProperties();
		
		// code to read external data file txt
		ReadDataFile rdf = new ReadDataFile();
		String [] data = rdf.readFile();
		for (int i = 0; i < data.length; i++) {
			System.out.println("Data --> "+data[i]);
		}
		
		// input object to search anything on google
		By lblSearch = By.name("q");

		WebDriver driver = null;
		try {
			// method to create a new folder to save screenshots and log file
			GenerateFolders.createFolders();
			
			// create driver with our properties
			Browser b = new Browser();
			driver = b.setBrowser(PropertiesManager.browser);
			
			driver.get(PropertiesManager.urlBase);
			MainFunctions m = new MainFunctions(driver);
			m.overwrite(lblSearch, "hello");
			b.takeScreenshot(driver, "Screenshot-1");
			
			// method to write into log file
			m.logReport("ERROR", "Element not clickable");
			m.logReport("ERROR", "Element not clickable 2");
			m.logReport("ERROR", "Element not clickable 3");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Closing driver...");
			driver.quit();
			System.out.println("Driver closed");
		}
	}
}
