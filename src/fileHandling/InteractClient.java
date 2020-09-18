package fileHandling;

import java.awt.Point;
import java.util.ArrayList;

public class InteractClient {
	public ArrayList<Point> getPointList() {
		ArrayList<Point> pointCollection = new ArrayList<Point>();
		ReadFile rfObj = new ReadFile();
		rfObj.initiateRequests();
		ArrayList<Coordinates> newCoors=  rfObj.getCoordinates();
		
		for (Coordinates c : newCoors) {
			pointCollection.add(c.getPoints());
		}
		return pointCollection;
	}
}
