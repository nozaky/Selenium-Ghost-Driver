package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

	//Variables to get Data
	public static String	urlBase,
							user,
							pass,
							drivers,
							screenshotsFolder,
							browser,
							dataFile;
	
	/**
	 * Constructor
	 */
	public PropertiesManager() {
	}
	
	/**
	 * Method to read Properties file
	 */
	public void readProperties() {
		Properties p = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			p.load(input);
			
			urlBase = p.getProperty("URLBASE");
			user = p.getProperty("USER");
			pass = p.getProperty("PASS");
			drivers = p.getProperty("DRIVERS");
			screenshotsFolder = p.getProperty("SCREENSHOTS-PATH");
			browser = p.getProperty("BROWSER");
			dataFile = p.getProperty("DATAFILE");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
