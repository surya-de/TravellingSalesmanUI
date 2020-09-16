package fileHandling;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class ReadFile {
	
	private static String FILE_PATH = "././res/wi29.tsp";
	private static int NUM_CITIES = 0;
	/**
	 * 
	 * Method to get th  dimensions from file.
	 * @author Suryadeep
	 */
	private void getDimensions() {
		
		FileInputStream fstream = null;
		
		try {
			fstream = new FileInputStream(FILE_PATH);
		} 
		
		catch (FileNotFoundException e1) {
			System.out.println("File not found in the path- " +e1);
		}
		
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
		try {
			String templine = br.readLine();
			while(!templine.contains("DIMENSION")) {
				templine = br.readLine();
			}
			NUM_CITIES = Integer.parseInt(templine.split(":")[1].trim());
		}
		
		catch(Exception e) {
			System.out.println("Error while reading file in get dimensions- " + e );
		}
	}
	
	public void respondRequests() {
		getDimensions();
		System.out.println(NUM_CITIES);
	}
}
