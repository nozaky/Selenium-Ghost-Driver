package POCustomers;

import org.openqa.selenium.WebDriver;

import base.MainFunctions;

/**
 * @author daniel Montero Lopez
 * 
 */
public class CustomerHomePage {

	
	WebDriver driver;
	MainFunctions m;
	
	/**
	 * Constructor
	 */
	public CustomerHomePage(WebDriver driver) {
		this.driver = driver;
		this.m = new MainFunctions(driver);
	}
	
	//By elements declaration
	
	
	
	
	
	
	//********************************************************************************************************************************
	
	/**
	 * Method to set user
	 * @param user = User Name
	 */
	public void setUser(String user) {
//		m.overwrite(element, user);
	}
	
	/**
	 * Method to set password
	 * @param pass = User password
	 */
	public void setPassword(String pass) {
//		m.overwrite(element, pass);
	}
	
	/**
	 * Method to click on Accept Button
	 */
	public void clickAccept() {
//		m.waitAndClick(element);
	}
	
}
