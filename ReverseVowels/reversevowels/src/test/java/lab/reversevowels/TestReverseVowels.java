package lab.reversevowels;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestReverseVowels 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestTokenizeStringMustReturnPopulatedArrayList()
    {
        String s ="LeetCode";
        ArrayList<String> resultArrayList = ReverseVowels.tokenizeString(s);

        for (String c:resultArrayList)
        {
            System.out.println(c);
        }
    }
}
