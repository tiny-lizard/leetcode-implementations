package lab.movezeroes;

/**
 *
 */
public class MoveZeroes 
{
    public static void main( String[] args )
    {
        int[] inputArray = {0,0,1};
        moveZeroes(inputArray);
        System.out.println( "Run completed." );
    }

    public static void moveZeroes(int[] nums)
    {
        int traversalpointer, endpointer;

        traversalpointer = 0;
        endpointer = nums.length -1; // last index of nums

        while (traversalpointer < endpointer)
        {
            if (nums[traversalpointer] == 0)
            {
                //move all values in the array from nums[traversalpointer + 1] to nums[endpointer] one space to the left.
                shiftArrayValues(nums,traversalpointer,endpointer);

                //set the value held by the endpointer to 0 (move the zero to the end of the array)
                nums[endpointer] = 0;

                //decrement endpointer so it points to the last non-zero element again.
                endpointer--;
            }
            else
                traversalpointer++;
        }
    }

    public static void shiftArrayValues(int[] targetArray, int startIndex, int endIndex)
    {
        while(startIndex < endIndex)
        {  
            targetArray[startIndex] = targetArray[startIndex+1];
            startIndex++;
        }
    }
}
