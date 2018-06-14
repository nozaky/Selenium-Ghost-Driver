package POProspects;

import org.openqa.selenium.WebDriver;

import base.MainFunctions;

/**
 * @author daniel montero lopez
 *
 */
public class ProspectHomePage {

	
	WebDriver driver;
	MainFunctions m;
	
	/**
	 * Constructor
	 */
	public ProspectHomePage(WebDriver driver) {
		this.driver = driver;
		this.m = new MainFunctions(driver);
	}
	
	//By elements declarations
	
	
	
	
	
	//********************************************************************************************************************************

	/**
	 * Method to set User
	 * @param user = user Name
	 */
	public void setUser(String user) {
//		m.overwrite(element, user);
	}
	
	/**
	 * Method to set Password
	 * @param pass = User password
	 */
	public void setPassword(String pass) {
//		m.overwrite(element, pass);
	}
	
	/**
	 * Method to click on Accept button
	 */
	public void clickAccept() {
//		m.waitAndClick(element);
	}
}
