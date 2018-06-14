package utils;

import java.io.File;

public class GenerateFolders {

	
	public static void createFolders() {
		File patherPath = new File(PropertiesManager.screenshotsFolder);
		if (!patherPath.exists()) {
			patherPath.mkdir();
		}
	}
}
