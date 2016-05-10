package knapsack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Knapsack
{
	/**
	 * The main function runs the program. The user is prompted to enter a 
	 * file name. A timer is started. The file is read in, sorted, and the
	 * knapsack problem is calculated. The timer is stopped. The answer is
	 * then printed and so is the time.  
	 * @param args
	 * @throws FileNotFoundException
	 */	
    public static void main (String[] args) throws FileNotFoundException 
    {
    	/// Prompt the user to enter a file name
    	System.out.print("Enter a file name: ");
    	Scanner s = new Scanner(System.in);
    	File file = new File(s.nextLine());
    	s.close();
    		    	
    	// Start the timer
    	long start = System.nanoTime();
    	
    	// Open the file name and read in each 
    	// line of the file
    	Scanner fscanner = new Scanner(file);
    	ArrayList<String> lines = new ArrayList<String>(); 
    	while(fscanner.hasNext()) {
    	   	lines.add(fscanner.nextLine());
    	}
    	fscanner.close();
	    
    	 // Sort file by max, weight and value
    	Knapsack ks = new Knapsack();
    	int size  = lines.size(); 
    	int max = Integer.parseInt(lines.get(0)); 
        int[] weights = new int[size + 1];
        int[] values = new int[size + 1];
		for(int i = 1; i < lines.size(); i++) {
			String[] split = lines.get(i).split("\\s+");
			weights[i] = Integer.parseInt(split[0]);
			values[i] = Integer.parseInt(split[1]);
		}
		System.out.println();
		
		// Solve the knapsack problem 
        ks.solve(weights, values, max, size);
        
 		// Stop timer
	    long end = System.nanoTime();
	    System.out.println("The answer was calcualted in " + (double)(end - start) / 1000000000.0 + " seconds.");
    }
    
    /**
	 * The solve() method solves the knapsack problem 
	 * and calculates the highest value without going over
	 * the max weight. This is done by comparing each line 
	 * of a matrix to the line above, and checking that the 
	 * weight is not exceeding max. 
	 */	
    public void solve(int[] weights, int[] values, int max, int size)
    {
    	// Create two matrixs to store results 
        int[][] m = new int[size + 1][max + 1];
        int[][] answer = new int[size + 1][max + 1];
 
        // Fill in each row of matrix 
        for (int i = 1; i <= size; i++)
        {
        	// Go through each weight 
            for (int w = 0; w <= max; w++)
            {
            	// Set a1 and a2
                int a1 = m[i - 1][w];
                int a2 = 0; 
                // Check if weight is greater than weight of item
                if (w >= weights[i]) {
                	// Change a2 if weight fits
                    a2 = m[i - 1][w - weights[i]] + values[i];
                }
                // Select the larger value
                m[i][w] = Math.max(a1, a2);
                // Fill matrix with 1 if a2 was greater
                // and 0 if a1 was greater 
                if(a2 > a1) {
                	answer[i][w] = 1;
                }
                else {
                	answer[i][w] = 0;
                }
            }
        }        
        // Make list of what all items that were selected
        int[] selected = new int[size + 1];
        for (int n = size, w = max; n > 0; n--)
        {
            if (answer[n][w] != 0)
            {
                selected[n] = 1;
                w = w - weights[n];
            }
            else
                selected[n] = 0;
        }
        
        // Find total items and total value of knapsack
        int total = 0;
        int items = 0;
        for (int i = 1; i < size + 1; i++){
            if (selected[i] == 1){
            	total += values[i];
            	items++;
            }
        }
        System.out.println("The number of items in the knapsack is " + items + ".");
        System.out.println("The total value of the items in the knapsack is " + total + ".");
    }
    
}