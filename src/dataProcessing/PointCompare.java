package dataProcessing;
import java.awt.Point;
import java.util.Comparator;

public class PointCompare implements Comparator<Point> {

	@Override
	public int compare(Point p1, Point p2) {
		if (p1.y > p2.y){
			return -1;
		}
		
		else if(p1.y < p2.y) {
			return 1;
		}
		
		else {
			int result = Double.compare(p1.x, p2.x);
			return result;
		}
	}

}
