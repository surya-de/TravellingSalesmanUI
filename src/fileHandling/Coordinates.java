package fileHandling;

import java.awt.Point;

public class Coordinates {
	private int x;
	private int y;
	private Point coorPoint;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
		convertPoints();
	}
	
	public void convertPoints() {
		coorPoint = new Point(x, y);
	}
	
	public Point getPoints() {
		return this.coorPoint;
	}
}
