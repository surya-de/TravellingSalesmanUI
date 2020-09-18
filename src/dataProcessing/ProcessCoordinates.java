package dataProcessing;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

import fileHandling.InteractClient;

public class ProcessCoordinates {
	ArrayList<Point> orderedStore;
	ArrayList<ArrayList<Double>> distanceMatrix;
	
	/**
	 * Method that orders the points
	 * based on level.
	 * @author Suryadeep
	 */
	private void createCityId() {
		InteractClient isObj = new InteractClient();
		orderedStore = isObj.getPointList();
		Collections.sort(this.orderedStore, new PointCompare()); 
	}
	
	/**
	 * Method to calculate distances
	 * amongst the points.
	 * @author Suryadeep
	 */
	private void storeDistance() {
		distanceMatrix = new ArrayList<ArrayList<Double>>();
		int cntr = 0;
		for (Point p : orderedStore) {
			distanceMatrix.add(new ArrayList<Double>());
			for (int i = 0; i < orderedStore.size(); i++) {
				if (cntr != i) {
					double distance = calculateDistance(p.x, p.y, orderedStore.get(i).x, orderedStore.get(i).y);
					distanceMatrix.get(cntr).add(distance);
				}
				
				else {
					distanceMatrix.get(cntr).add(0.0);
				}

			}
			
			cntr += 1;
		}
	}
	
	private double calculateDistance(int x1, int y1, int x2, int y2) {
		double dist = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		return dist;
	}
	
	public void initiateInteraction() {
		createCityId();
		storeDistance();
	}
	
	public ArrayList<ArrayList<Double>> getDistances(){
		return distanceMatrix;
	}
}
