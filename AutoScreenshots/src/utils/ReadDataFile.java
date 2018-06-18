package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFile {

	public String[] numberData;
	
	public String[] readFile() {
		File file = new File(PropertiesManager.dataFile);
		FileReader fr1;
		int numLines = 0;
		String line;
		try {
			fr1 = new FileReader(file);
			BufferedReader br1 = new BufferedReader(fr1);
			if (file.exists()) {
				while ((line = br1.readLine())!=null) {
					numLines++;
				}
				br1.close();
				fr1.close();
				FileReader fr2 = new FileReader(file);
				BufferedReader br2 = new BufferedReader(fr2);
				numberData = new String[numLines];
				int pos = 0;
				while ((line = br2.readLine())!=null) {
					numberData[pos] = line;
					pos++;
				}
				fr2.close();
				br2.close();
			}
			//Show data on DataFile
//			for (int i = 0; i < numberData.length; i++) {
//				System.out.println("Data "+i+": "+numberData[i]);
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberData;
	}
	
	
}
