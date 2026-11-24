package lab.reversevowels2;

/**
 * Hello world!
 *
 */
public class ReverseVowels2 
{
    public static void main( String[] args )
    {
        String inputString = "aquiantance";
        String outputString = reverseVowels2(inputString);
        System.out.println( outputString);        
        System.out.println( "Run Completed." );
    }

    public static String reverseVowels2(String s)
    {
        //Reimplement reverse vowels puzzle using a 2-pointer solution
        char[] tokenizedString = s.toCharArray();
        String result = "";

        int startPointer =0;
        int endPointer = tokenizedString.length-1;

        String vowels = "aeiouAEIOU";
        
        while(startPointer < endPointer)
        {
            //Have the starting pointer traverse the tokenized string array until it finds a vowel.
            while (startPointer < endPointer && vowels.indexOf(tokenizedString[startPointer]) == -1)
            {
                startPointer++;
            }

            //Have the end pointer traverse the tokenized string array from the last element in reverse until it finds a vowel.
            while (startPointer < endPointer && vowels.indexOf(tokenizedString[endPointer]) == -1)
            {
                endPointer--;
            }

            //Swap vowels.
            char temp = tokenizedString[startPointer];
            tokenizedString[startPointer] = tokenizedString[endPointer];
            tokenizedString[endPointer] = temp;

            //Move pointers
            startPointer++;
            endPointer--;
        }

        result = new String(tokenizedString);
        return result;
    }
}
