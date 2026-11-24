package lab.maxconsecutiveones3;

import java.util.Arrays;

/**
 *
 */
public class MaxConsecutiveOnes3 
{
    public static void main( String[] args )
    {
        int[] inputArray = {0,0,0,1};
        int output = longestOnes(inputArray, 0);
        System.out.println(output);
        System.out.println( "Run completed." );
    }

    public static int longestOnes(int[] nums, int k)
    {
        int currMaxConsecutiveOnes, startPointer, endPointer, initialFlippedZeroes, candidateLength;

        currMaxConsecutiveOnes = 0;
        startPointer = 0;
        endPointer = 0;
        candidateLength = 0;
        initialFlippedZeroes = 0;

       
        do {
            if (k > 0)
            {
                //traverse array and flip initial set of 0's to "1"'s.
                //To differentiate input 1's and flipped 1's, flipped 1's will be expressed as 2's instead.
                while (endPointer < nums.length && initialFlippedZeroes < k)
                {
                    if (nums[endPointer] == 0)
                    {
                        //Identify index where the first 0 is flipped
                        if (initialFlippedZeroes == 0)
                            startPointer = endPointer;
                        nums[endPointer] = 2;
                        initialFlippedZeroes++;
                    }

                    endPointer++;
                }
            }

            //Check length of consecutive 1's in the array.
            //If a 0 is read in, check if length is greater than current longest length, then reset count to 0 until another 1 is read in.
            for (int i: nums)
            {
                if (i * 1 >= 1)
                    candidateLength++;
                else
                    {
                        if (candidateLength > currMaxConsecutiveOnes)
                            currMaxConsecutiveOnes = candidateLength;
                        
                        candidateLength = 0;
                    }
            }

            if (candidateLength > currMaxConsecutiveOnes)
            currMaxConsecutiveOnes = candidateLength;

            if (k > 0)
            {
                //So long as k > 0, slide start pointer one 2 position to the right.
                nums[startPointer] = 0;
                while (startPointer < endPointer && nums[startPointer] != 2)
                    startPointer++;
                
                //slide end pointer one 0 position to the right
                while(endPointer < nums.length && nums[endPointer] != 0)
                {
                    if (nums[endPointer] != 0)
                        endPointer++;
                }
                if (endPointer < nums.length)
                    nums[endPointer] = 2; 
            }
        } while (endPointer < nums.length && k > 0);

        return currMaxConsecutiveOnes;
    }
}
