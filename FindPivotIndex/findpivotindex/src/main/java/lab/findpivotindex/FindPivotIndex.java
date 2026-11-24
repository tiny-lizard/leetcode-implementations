package lab.findpivotindex;

/**
 *
 */
public class FindPivotIndex 
{
    public static void main( String[] args )
    {
        int[] inputArray = {1,1};
        int output = pivotIdex(inputArray);
        System.out.println(output);
        System.out.println("Run completed.");
    }

    public static int pivotIdex(int[] nums)
    {
        int leftPivotSum, rightPivotSum, leftPointer;
        leftPivotSum = 0;
        rightPivotSum = 0;
        leftPointer = 0;

        while (leftPointer < nums.length)
        {
            if(leftPointer > 0)
                leftPivotSum = leftPivotSum + nums[leftPointer - 1];
            
            // evaluate sum of values in indices to the right of the current pivot
            for (int rightPointer = leftPointer + 1; rightPointer < nums.length; rightPointer++)
            {
                rightPivotSum = rightPivotSum + nums[rightPointer];
            }

            if(leftPivotSum == rightPivotSum)
                return leftPointer;
            else
                leftPointer++;
                rightPivotSum = 0;

        }

            return -1;
    }
}
