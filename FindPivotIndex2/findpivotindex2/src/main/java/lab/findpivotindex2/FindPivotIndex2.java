package lab.findpivotindex2;

/**
 * Hello world!
 *
 */
public class FindPivotIndex2 
{
    public static void main( String[] args )
    {
        int[] inputArray = {2,1,-1};
        int output = pivotIndex2(inputArray);
        System.out.println(output);
        System.out.println( "Run completed" );
    }

    public static int pivotIndex2(int[] nums)
    {
        int[] leftPivotSums = new int[nums.length];
        int tempLeftPivotSum = 0;
        int rightPivotSum = 0;
        int currPivotIndex = -1;

        //account for nums[0] case
        leftPivotSums[0] = 0;

        //populate tempLeftPivotSum with interim prefix sums of the leftside values
        for (int leftPointer = 1; leftPointer < nums.length; leftPointer++)
        {
            tempLeftPivotSum = tempLeftPivotSum + nums[leftPointer - 1];
            leftPivotSums[leftPointer] = tempLeftPivotSum;
        }

        //account for nums[last element] case
        if(leftPivotSums[nums.length-1] == 0)
            currPivotIndex = nums.length-1;

        //do a running sum of the rightside values and check if a pivot index is found
        for (int rightPointer = nums.length-2; rightPointer >= 0; rightPointer--)
        {
            rightPivotSum = rightPivotSum + nums[rightPointer+1];
            
            // check if a pivot index has been found
            if (leftPivotSums[rightPointer] == rightPivotSum)
                currPivotIndex = rightPointer;
        }

        return currPivotIndex;
    }
}
