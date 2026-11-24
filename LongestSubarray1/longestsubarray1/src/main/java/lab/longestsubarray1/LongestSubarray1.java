package lab.longestsubarray1;

/**
 * Hello world!
 *
 */
public class LongestSubarray1 
{
    public static void main( String[] args )
    {
        int[] inputArray = {1,1,0,0,1,1,1,0,1};
        int output = longestSubarray(inputArray);
        System.out.println(output);
        System.out.println( "Run completed." );
    }

    public static int longestSubarray(int[] nums)
    {
        int currLongestSubarray, currLength, zeroSkip, startPointer, endPointer;

        currLength = 0;
        zeroSkip = -1;
        startPointer = 0;
        endPointer = 0;

        //set up initial window. Find first window of elements including one skipped 0. Count length while traversing through elements.
        while (endPointer < nums.length)
        {
            if(nums[endPointer]==0)
            {
                if (zeroSkip == -1)
                {
                    zeroSkip = endPointer; // Remember index of skipped/"removed" 0
                    endPointer++;
                }
                else
                    break; //if a zero has already been skipped/"removed", stop traversing at the next encountered 0.
            }
            else
            {
                endPointer++;
                currLength++;
            }
        }

        currLongestSubarray = currLength;

        //Account for edge cases where there is only one 0 or no 0's.
        if(endPointer == nums.length)
        {
            if (zeroSkip > -1)
                return currLongestSubarray; // if only one 0 was skipped/"removed" and the entire array was traversed, return length as is.
            else
                return currLongestSubarray - 1; // if no 0 was skipped/"removed" and the entire array was traversed, 
                                               //return the length subtracted by 1 because one element must be removed.
        }

        //In all other cases, traverse the rest of the array after setting up the initial window
        //slide window then evaluate length

        while (endPointer < nums.length )
        {
            //adjust currLength to accommodate difference. slide start pointer one 0 position to the right. Have it point to the position after the 0.
            currLength = currLength - (zeroSkip - startPointer);
            startPointer = zeroSkip + 1;
            zeroSkip = -1;
            
            while(endPointer < nums.length)
            {
                if (nums[endPointer] == 0)
                {
                    if (zeroSkip == -1)
                    {
                        zeroSkip = endPointer;
                        endPointer++;
                    }
                    else
                        break;
                }
                else
                {
                    endPointer++;
                    currLength++;
                }
            }

            //evaluate length
            if (currLength > currLongestSubarray)
                currLongestSubarray = currLength;
        }

        return currLongestSubarray;
    }
}
