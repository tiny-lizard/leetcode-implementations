package lab.ksumpairs;

/**
 * Hello world!
 *
 */
public class KSumPairs 
{
    public static void main( String[] args )
    {
        int[] inputArray = {3,1,3,4,3};
        int inputK = 5;
        System.out.println("Maximum Operations: " + maxOperations(inputArray, inputK));
        System.out.println( "Run completed." );
    }

    public static int maxOperations(int[] nums, int k)
    {
        int maxOperations, startPointer, traversePointer, kPair;

        maxOperations = 0;
        startPointer = 0;
        traversePointer = 1; //index must be startPointer + 1

        while (startPointer < nums.length && traversePointer < nums.length)
        {
            //check if pointers are pointing to a k-sum pair.
            if (nums[startPointer] + nums[traversePointer] == k )
            {
                //increment start pointer to next position, then swap values with traverse pointer (move both pairs to head of array)
                startPointer++; 
                kPair = nums[traversePointer];
                nums[traversePointer] = nums[startPointer];
                nums[startPointer] = kPair;

                //set pointers to new positions after the k-pairs.
                startPointer++; 
                traversePointer = startPointer + 1;
                maxOperations++;
                continue;
            }

            if(traversePointer == nums.length-1)
            {
                startPointer++;
                traversePointer = startPointer + 1;
            }
            else
                traversePointer++;

        }

        return maxOperations;
    }

}
