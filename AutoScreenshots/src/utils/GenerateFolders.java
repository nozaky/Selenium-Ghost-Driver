package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateFolders {

	
	public static void createFolders() {
		File patherPath = new File(PropertiesManager.screenshotsFolder);
		if (!patherPath.exists()) {
			patherPath.mkdir();
		}
		generateReportFile();
	}
	
	private static void generateReportFile() {
		try {
			File file = new File(PropertiesManager.screenshotsFolder+"/logError.txt");
			if (file.exists()) {
				file.delete();
				file = new File(PropertiesManager.screenshotsFolder+"/logError.txt");
			}
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
