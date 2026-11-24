package lab.mergesort;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MergeSortTest 
{
    @Test
    public void midOfZeroAndSixIsTwo()
    {
        //calculated midpoint of 0 and 5 is 2.
        assertEquals(2,MergeSort.determineMid(0,5));
    }

    @Test
    public void midOfFourAndFiveisFour()
    {
        //calculated midpoint of 5 and 6 is 6.
        assertEquals(4,MergeSort.determineMid(4,5));
    }

    @Test
    public void confirmLeftSubArrayIndices1()
    {
        //Confirms that the generated subarray length is as expected WRT to index parameters
        //For the following indices, the length should be 3.
        // first = 0    mid = 2
        assertEquals(3,MergeSort.setLeftArrayLength(0,2));
    }

    @Test
    public void confirmRightSubArrayIndices2()
    {
        //Confirms that the generated subarray length is as expected WRT to index parameters
        //For the following indices, the length should be 3
        // mid = 3    last = 5
        assertEquals(3,MergeSort.setLeftArrayLength(3,5));
    }

    @Test
    public void confirmMergeIteration()
    {
        int[] testArray = {29,345,4567,6,789,10};
        int tFirst = 3;
        int tMid = 4;
        int tLast = 5;

        //assert

    }
}
