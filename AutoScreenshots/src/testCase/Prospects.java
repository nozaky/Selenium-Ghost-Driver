package testCase;

import org.openqa.selenium.WebDriver;

import base.Browser;
import utils.GenerateFolders;
import utils.PropertiesManager;

/**
 * @author daniel Montero Lopez
 * To Santander UK
 */
public class Prospects {

	
	/**
	 * Method to take screenshots on Prospects BKS
	 * @param args
	 */
	public static void main(String[] args) {
		//initialize variables for the config.properties
		PropertiesManager p = new PropertiesManager();
		//generate folder structure
		GenerateFolders.createFolders();
		WebDriver driver = null;
		Browser b = new Browser();
		driver = b.setBrowser(PropertiesManager.browser);
	}
}
