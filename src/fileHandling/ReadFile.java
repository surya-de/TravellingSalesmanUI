package fileHandling;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadFile {
	
	private static String FILE_PATH = "././res/wi29.tsp";
	private static int NUM_CITIES;
	private static FileInputStream fstream;
    private static DataInputStream in;
    private static BufferedReader br;
    private static Coordinates coordObj;
    private static ArrayList<Coordinates> LocationStore = new ArrayList<Coordinates>();
	
    /**
	 * 
	 * Method to get the dimensions from file.
	 * @author Suryadeep
	 */
	private void getDimensions() {
		
		try {
			fstream = new FileInputStream(FILE_PATH);
		} 
		
		catch (FileNotFoundException e1) {
			System.out.println("File not found in the path- " +e1);
		}
		
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in)); 
		
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
	
	/**
	 * Method to fetch the coordinates.
	 * @author Suryadeep
	 */
	private void findCoordinates() {
		try {
			fstream = new FileInputStream(FILE_PATH);
		} 
		
		catch (FileNotFoundException e1) {
			System.out.println("File not found in the path- " +e1);
		}
		
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in)); 
		
		try {
			String tempStore = br.readLine(); 
			
			while (!tempStore.equals("NODE_COORD_SECTION")) {
				tempStore = br.readLine();
			}
			
			/**
			 * Read the coordinates till EOF
			 * is reached.
			 */
			while (!tempStore.equals("EOF")) {
				tempStore = br.readLine();
				// Add the coordinates
				if (!tempStore.equals("EOF")) {
					int trav_x = (int)Double.parseDouble(tempStore.split("\\s+")[1]);
					int trav_y = (int)Double.parseDouble(tempStore.split("\\s+")[2]);
					coordObj = new Coordinates(trav_x, trav_y);
					LocationStore.add(coordObj);
				}
			}
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initiateRequests() {
		getDimensions();
		findCoordinates();
	}
	
	public ArrayList<Coordinates> getCoordinates() {
		return LocationStore;
	}
}