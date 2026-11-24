package lab.tripletsubsequence;

/**
 * Hello world!
 *
 */
public class TripletSubsequence 
{
    public static void main( String[] args )
    {
        int[] inputArray = {0,4,2,1,0,-1,-3};
        Boolean output = increasingTriplet(inputArray);
        System.out.println(output);
        System.out.println( "Run completed." );
    }

    public static boolean increasingTriplet(int[] nums)
    {
        int lowIndex, midIndex, currIndex;
        
        currIndex = 0;
        lowIndex = 0;
        midIndex = 0;

        while(currIndex < nums.length)
        {

        //Inside the while loop, iterate through each element in the array by checking if it is eligible to be any of the target indices in the triplet.
        //If at the starting index, set as lowest index
        //If the number is lower than the current lowest index, set as new lowest index.
        if (currIndex == 0 || nums[currIndex] < nums[lowIndex])
            lowIndex = currIndex;
        
        //if the number is greater than the current lowest index AND the number is lower than the current midIndex, set as the new midIndex. 
        else if (nums[currIndex] > nums[lowIndex] && nums[currIndex] < nums[midIndex]) //covers subsequent midIndex cases 
            midIndex = currIndex;
        
        else if (nums[currIndex] > nums[lowIndex] && midIndex == 0 ) //covers the initial midIndex case
             midIndex = currIndex;
        
        //if the number is greater than the current midIndex, a valid triplet was found. return true.
        else if (nums[currIndex] > nums[midIndex])
            return true;
        
        currIndex++;
        }

        return false;

    }
}
