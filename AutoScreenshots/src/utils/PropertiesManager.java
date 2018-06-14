package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

	//Var to get Data
	public static String	url,
							user,
							pass,
							drivers;
	
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
			
			url = p.getProperty("URL");
			user = p.getProperty("USER");
			pass = p.getProperty("PASS");
			drivers = p.getProperty("DRIVERS");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}