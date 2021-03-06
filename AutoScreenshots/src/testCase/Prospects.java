package testCase;

import org.openqa.selenium.WebDriver;

import POProspects.ProspectHomePage;
import base.Browser;
import utils.GenerateFolders;
import utils.PropertiesManager;

/**
 * @author daniel Montero Lopez
 * To Santander UK
 */
public class Prospects {

	
	/**
	 * Method to take screenshots for the Prospects BKS
	 * @param args
	 */
	public static void main(String[] args) {
		//initialize variables for the config.properties
		PropertiesManager p = new PropertiesManager();
		//generate folder structure
		GenerateFolders.createFolders();
		//create Driver
		WebDriver driver = null;
		//Create new Browser object
		Browser b = new Browser();
		//setting driver object
		try {
			driver = b.setBrowser(PropertiesManager.browser);
			//going to URL
			driver.get(PropertiesManager.urlProspect);
			//create Prospect Home Page object
			ProspectHomePage pHome = new ProspectHomePage(driver);
			//insert User
			pHome.setUser(PropertiesManager.user);
			//insert Password
			pHome.setPassword(PropertiesManager.pass);
			//click on Accept Button to login
			pHome.clickAccept();			
		} catch (Exception e) {
			
		}finally {
			System.out.println("Closing driver...");
			driver.quit();
			System.out.println("Driver closed");
		}
		
		
	}
}
