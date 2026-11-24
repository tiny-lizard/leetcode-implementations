package lab.watercontainer;

/**
 *
 */
public class WaterContainer 
{
    public static void main( String[] args )
    {
        int[] inputHeights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(inputHeights));
        System.out.println( "Run completed." );
    }

    public static int maxArea(int[] height)
    {
        int startPointer, endPointer, currHeight, currWidth, currLargestArea, candidateArea;

        startPointer = 0;
        endPointer = height.length-1;
        currLargestArea = 0;

        while(startPointer < endPointer)
        {
            //Set up width
            currWidth = endPointer - startPointer;

            //Identify the pointer with the lower height. Set this as the height to be used to compute area.
            //Afterwards, increment/decrement the pointer with the lower height so that it moves towards the middle of the array. 
            //Take care not to do more operations with the pointers after incrementing.
            if (height[startPointer] < height[endPointer])
            {
                currHeight = height[startPointer];
                startPointer++;
            }
            else
            {
                currHeight = height[endPointer];
                endPointer--;
            }

            candidateArea = currHeight * currWidth;

            //Determine whether the candidate area is greater than the current largest area.
            if (candidateArea > currLargestArea)
                currLargestArea = candidateArea;
        }

        return currLargestArea;
    }
}
