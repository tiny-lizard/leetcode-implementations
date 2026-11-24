package lab.placeflowers;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestCanPlaceFlowers 
{
    /**
     * Tester for the canPlaceFlowers method.
     * canPlaceFlowers must return true if the parameter n is equal to the method variable noAdjFlwrCount
     */
    @Test
    public void ifNoAdjFlwrCountEqualsNReturnTrue()
    {
        int testN = 1;
        int[] testFlowerBed = {1,0,0,0,0,1};
        assertTrue(PlaceFlowers.canPlaceFlowers(testFlowerBed,testN));

    }

     /**
     * Tester for the canPlaceFlowers method.
     * canPlaceFlowers must return true if the parameter n is equal to the method variable noAdjFlwrCount
     */
    @Test
    public void ifNoAdjFlwrCountNotEqualsNReturnFalse()
    {
        int testN = 2;
        int[] testFlowerBed = {1,0,0,0,0,1};
        assertFalse(PlaceFlowers.canPlaceFlowers(testFlowerBed,testN));

    }
}
