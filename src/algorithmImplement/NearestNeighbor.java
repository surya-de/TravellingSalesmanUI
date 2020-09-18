package algorithmImplement;

import java.util.ArrayList;
import java.util.Stack;

public class NearestNeighbor {
    private int numberOfNodes;
    private Stack<Integer> stack;
    private ArrayList<Integer> optimalPath = new ArrayList<Integer>();
    private double cost = 0.0;
 
    public NearestNeighbor() {
        stack = new Stack<Integer>();
    }
    
    /**
     * 
     * @param locations
     * Method to perform Nearest Neighbor Algorithm.
     */
    public void performNearestNeighbor(ArrayList<ArrayList<Double>> locations) {
    	double prev = 0.0;
    	int START_NODE = 1;
        numberOfNodes = locations.get(0).size() - 1;
        int[] visited = new int[numberOfNodes + 1];
        visited[START_NODE] = 1;
        stack.push(START_NODE);
        int element, curr = 0, i;
        double min = Integer.MAX_VALUE;
        boolean minFlag = false;
        optimalPath.add(1);
        
        /**
         * Perform DFS based on the nodes visited.
         */
        while (!stack.isEmpty()) {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            
            while (i <= numberOfNodes) {
                if (locations.get(element).get(i) > 0 && visited[i] == 0) {
                    
                	/**
                	 * Update Minimum value for distance for each city.
                	 */
                	if (locations.get(element).get(i) < min) {
                        min = locations.get(element).get(i);
                        prev = locations.get(element).get(i);
                        curr = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            
            /**
             * Update the global minimum.
             */
            if (minFlag) {
                visited[curr] = 1;
                cost += prev;
                stack.push(curr);
                optimalPath.add(curr);
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        optimalPath.add(1);
        displayOutput();
    }
    
    /**
     * Method to display the output.
     */
    private void displayOutput() {
    	System.out.print("Cities-");
    	System.out.print("\n");
    	System.out.print(numberOfNodes + 1);
    	System.out.print("\n");
    	System.out.print("Optimal Path-");
    	System.out.print("\n");
    	for (int i = 0; i < optimalPath.size(); i++) {
    		if (i == optimalPath.size() - 1) {
    			System.out.print(optimalPath.get(i));
    		}
    		else {
    			
    			System.out.print(optimalPath.get(i) + " -> ");
    		}
    	}
    	System.out.print("\n");
    	System.out.print("Optimal Path Cost-");
    	System.out.print("\n");
    	System.out.print(cost);
    }
}
