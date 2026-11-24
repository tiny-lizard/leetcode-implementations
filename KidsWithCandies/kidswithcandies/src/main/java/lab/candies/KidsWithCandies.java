package lab.candies;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class KidsWithCandies 
{
    public static void main( String[] args )
    {

        int[] candies ={2,4,6,1,1};
        int extraCandies = 4;
        List<Boolean> output;

        output = processKidsWithCandies(candies, extraCandies);

        System.out.println(output);
        System.out.println( "Run completed." );
    }

    public static List<Boolean> processKidsWithCandies(int[] pCandies, int pExtraCandies)
    {
        int kidWithExtraCandies = 0;
        Boolean tempResult;

        List<Boolean> result = new ArrayList<>(); //boolean arraylist to be returned.
        
        for (int i =0; i < pCandies.length;i++)
        {
            tempResult = true;
            kidWithExtraCandies = pCandies[i] + pExtraCandies;
            for (int j=0; j < pCandies.length; j++)
            {
                if (kidWithExtraCandies < pCandies[j])
                {
                    tempResult = false;
                    break;
                }
            }
            result.add(i,tempResult);
        }

        return result;
    }

// Smaller subfunctions ----------------------------------------------------------

}
