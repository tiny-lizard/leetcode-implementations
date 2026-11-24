package lab.placeflowers;

/**
 * Hello world!
 *
 */
public class PlaceFlowers 
{
    public static void main( String[] args )
    {
        System.out.println( "Run Completed." );
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n)
    {
        int noAdjFlwrCount = 0;
        int prev, next;
        for (int i = 0; i<flowerbed.length;i++)
        {
            //check if current plot is 0/does not already have a flower.
            if(flowerbed[i]==0)
            {
                //"look" at the previous and next values in the array/ "plots" in the flowerbed.
                prev = getPrev(flowerbed, i);
                next = getNext(flowerbed, i);
    
                if(prev == 0 && next ==0)
                {   
                    //If spot has no adjacent flowers, increase count and "place" a flower/change current index to 1.
                    //Changing this index to 1 ensures the program "remembers" the newly placed flower and will take this into account in the next iteration.
                    noAdjFlwrCount++;
                    flowerbed[i] = 1;
                }
            }
            
        }
        
        //n only needs to be equal to or less than the count. 
        //The question asked is whether n number of flowers can be placed,
        // so any number equal to or less than the No Adjacent Flower Count is a correct answer.
        if (n <= noAdjFlwrCount)
            return true;
        else
            return false;

    }

    // Getters

    public static int getPrev(int[] tFlowerbed, int currentIndex)
    {
        if(currentIndex > 0)
            return tFlowerbed[currentIndex-1];
        else
            return 0;
    }

    public static int getNext(int[] tFlowerbed, int currentIndex)
    {
        if(currentIndex < tFlowerbed.length-1)
            return tFlowerbed[currentIndex+1];
        else
            return 0;
    }


}
