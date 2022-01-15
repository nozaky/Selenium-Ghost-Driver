package base;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import utils.PropertiesManager;


public class Browser {

	private final String VISIBLE = "VISIBLE";
	private final String GHOST = "GHOST";
	
	private final String IE = "IE";
	private final String FIREFOX = "FIREFOX";
	private final String CHROME = "CHROME";
	
	/**
	 * Constructor
	 */
	public Browser(){
		
	}
	
	/**
	 * Method to select browser
	 * @param browser
	 */
	public WebDriver setBrowser(String browser) {
		
		WebDriver driver=null;
		try {
			int w = getScreenSize("width");
			int h = getScreenSize("height");
			String mode = PropertiesManager.drivers;
			if (mode==null || mode.isEmpty() || (!mode.equalsIgnoreCase(VISIBLE) && !mode.equalsIgnoreCase(GHOST))) {
				throw new InvalidArgumentException("Solo se admite 'visible' o 'ghost' como parámetro.");
			}
			if (browser!=null) {
				browser = browser.toUpperCase();
			}
			//If we select Invisible mode, ghost mode
			if (mode.equalsIgnoreCase(GHOST)) {
				switch (browser) {
				case IE:
					System.setProperty("webdriver.ie.driver", "drivers/headless_ie_selenium.exe");
					driver = new InternetExplorerDriver();		
					break;
				case CHROME:
					System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("headless");
					options.addArguments("window-size="+w+","+h);
					driver = new ChromeDriver(options);
					break;
				case FIREFOX:
					System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
					FirefoxBinary fb = new FirefoxBinary();
					fb.addCommandLineOptions("--headless");
					FirefoxOptions fo = new FirefoxOptions();
					fo.setBinary(fb);
					driver = new FirefoxDriver(fo);
					break;
				default:
					throw new InvalidArgumentException(browser+" argument isn't valid");
				}
			}
			//if We select visible mode, normal mode
			if (mode.equalsIgnoreCase(VISIBLE)) {
				switch (browser) {
				case IE:
					System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
					driver = new InternetExplorerDriver();		
					break;
				case CHROME:
					System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case FIREFOX:
					System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
					driver = new FirefoxDriver();
					break;
				default:
					throw new InvalidArgumentException(browser+" argument isn't valid");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	/**
	 * Method to Take Screenshot
	 * @param driver = driver to get Screenshot
	 * @param nameIMG = name of image
	 */
	public void takeScreenshot(WebDriver driver,String nameIMG){
	    try {
	    	//Take screenshot of the driver
	    	File from = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	//Create file on ScreenshotPath with name that we send by variable
	    	File to = new File(PropertiesManager.screenshotsFolder+"/"+nameIMG+".png");
	    	//screenshot copied on Folder
			FileHandler.copy(from, to);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to get screen dimension
	 * @param dim = with or height
	 * @return size = size of dimension
	 */
	private int getScreenSize(String dim) {
		int size=0;
		try {
			Toolkit t = Toolkit.getDefaultToolkit();
			Dimension screenSize = t.getScreenSize();
			if(dim.equalsIgnoreCase("width")) {
				size = screenSize.width;
			}
			if(dim.equalsIgnoreCase("height")) {
				size = screenSize.height;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		return size;
	}
}
