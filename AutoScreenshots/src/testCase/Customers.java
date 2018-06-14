package testCase;

import org.openqa.selenium.WebDriver;

import POCustomers.CustomerHomePage;
import base.Browser;
import utils.GenerateFolders;
import utils.PropertiesManager;

/**
 * @author daniel Montero Lopez
 * To Santander UK
 */
public class Customers {

	
	/**
	 * Method to take Screenshots for the Customers BKS
	 * @param args
	 */
	public static void main(String[] args) {
		//initialize variables for the config.properties
		PropertiesManager p = new PropertiesManager();
		//generate folder Structure
		GenerateFolders.createFolders();
		//create driver
		WebDriver driver = null;
		//create Browser Object
		try {
			Browser b = new Browser();
			//setting driver
			driver = b.setBrowser(PropertiesManager.browser);	
			//going to URL
			driver.get(PropertiesManager.urlCustomer);
			//create Customer Home Page object
			CustomerHomePage cHome = new CustomerHomePage(driver);
			//insert User
			cHome.setUser(PropertiesManager.user);
			//insert Password
			cHome.setPassword(PropertiesManager.pass);
			//click on Accept Button
			cHome.clickAccept();
			
		} catch (Exception e) {

		}finally {
			System.out.println("Closing driver...");
			driver.quit();
			System.out.println("Driver closed");
		}
	}
}
