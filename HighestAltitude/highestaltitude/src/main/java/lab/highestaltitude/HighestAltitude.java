package lab.highestaltitude;

/**
 * Hello world!
 *
 */
public class HighestAltitude 
{
    public static void main( String[] args )
    {
        int[] inputArray = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(inputArray));
        System.out.println( "Run completed." );
    }

    public static int largestAltitude (int[] gain)
    {
        int currHighestAltitude, currSum;

        currHighestAltitude = 0;
        currSum = 0;

        for(int i : gain)
        {
            currSum = currSum + i;
            if (currSum > currHighestAltitude)
                currHighestAltitude = currSum;
        }

        return currHighestAltitude;

    }
}
