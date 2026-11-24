package lab.maxavesubarray;

/**
 * Hello world!
 *
 */
public class MaxAverageSubarray 
{
    public static void main( String[] args )
    {
        int[] inputArray = {0,1,1,3,3};
        double result = findMaxAverage(inputArray, 4);
        System.out.println(result);
        System.out.println( "Run completed." );
    }

    public static double findMaxAverage(int[] nums, int k)
    {
        int startPointer, endPointer, subtotal;
        double currMaxAverage, candidateAverage;

        subtotal = 0;
        currMaxAverage = Integer.MIN_VALUE;

        // set up sliding window
        for (int i = 0; i < k; i++)
        {
            subtotal = subtotal + nums[i];
        }
        
        // traverse array using the sliding window
        startPointer = 0; //match starting index of window to starting index of array
        endPointer = k-1; // match end index of window to k (-1 as it is the index)
        while (endPointer < nums.length)
        {
            // Check if the average of values in the current window is greater than the current max average
            candidateAverage = (double) subtotal/k;
            if (candidateAverage > currMaxAverage)
                currMaxAverage = candidateAverage;
            
            // Move the window one position to the right if the window isn't already at the rightmost array element.

                subtotal = subtotal - nums[startPointer]; // "remove" leftmost value
                startPointer++; //increment starting index of window
    
                endPointer++; //increment end index of window
                if (endPointer <= nums.length-1)
                    subtotal = subtotal + nums[endPointer]; // add new value added into the window to the subtotal
        }

        return currMaxAverage;
    }
}
