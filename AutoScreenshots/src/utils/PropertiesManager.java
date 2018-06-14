package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

	//Var to get Data
	public static String	urlProspect,
							urlCustomer,
							user,
							pass,
							drivers,
							screenshotsFolder,
							browser;
	
	/**
	 * Constructor
	 */
	public PropertiesManager() {
		readProperties();
	}
	
	/**
	 * Method to read Properties file
	 */
	private void readProperties() {
		Properties p = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			p.load(input);
			
			urlProspect = p.getProperty("URL-PROSPECT");
			urlCustomer = p.getProperty("URL-CUSTOMER");
			user = p.getProperty("USER");
			pass = p.getProperty("PASS");
			drivers = p.getProperty("DRIVERS");
			screenshotsFolder = p.getProperty("SCREENSHOTS-PATH");
			browser = p.getProperty("BROWSER");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
