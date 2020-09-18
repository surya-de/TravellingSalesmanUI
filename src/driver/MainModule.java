package driver;
import dataProcessing.ProcessCoordinates;
import algorithmImplement.NearestNeighbor;

public class MainModule {

	public static void main(String[] args) {
		ProcessCoordinates pcObj = new ProcessCoordinates();
		NearestNeighbor nnObj = new NearestNeighbor();
		
		pcObj.initiateInteraction();
		nnObj.performNearestNeighbor(pcObj.getDistances());
	}

}
