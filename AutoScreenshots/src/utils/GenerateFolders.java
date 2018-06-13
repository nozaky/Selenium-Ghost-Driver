package utils;

import java.io.File;

public class GenerateFolders {

	
	public static void createFolders() {
		File patherPath = new File("C:/WorkspaceSandUK/Screenshots");
		if (!patherPath.exists()) {
			patherPath.mkdir();
		}
	}
}
