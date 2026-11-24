package lab.maxvowelssubstring;

/**
 *
 */
public class MaxVowelsSubstring 
{
    public static void main( String[] args )
    {
        String inputString = "a";
        System.out.println(maxVowels(inputString, 1));
        System.out.println( "Run completed." );
    }

    public static int maxVowels(String s, int k)
    {
        int maxVowels = 0;
        int vowelCount = 0;
        final String VOWELS = "AIEOUaieou";
        char[] tokenizedString = s.toCharArray();

        //Set up initial sliding window's maximum number of vowels
        for (int i = 0; i < k; i++)
        {
            vowelCount = vowelCount + isVowel(VOWELS, tokenizedString[i]);
            
            if (vowelCount > maxVowels)
            maxVowels = vowelCount;
        }

        //traverse the tokenized string array using the window
        if (s.length() > 1)
        {
            for(int i = 1, end = k - 1; i + end < s.length() ; i++)
            {
                vowelCount = vowelCount - isVowel(VOWELS, tokenizedString[i - 1]); // process leftmost element that will be excluded from window
                vowelCount = vowelCount + isVowel(VOWELS, tokenizedString[i + end]); //process new rightmost element added into window
            
                //Check if the current number of vowels in the window is greater than the current max
                if (vowelCount > maxVowels)
                    maxVowels = vowelCount;
            }
        }

        return maxVowels;
    }

    public static int isVowel(String V, char c )
    {
            if (V.indexOf(Character.toString(c)) != -1)
            return 1;
            else
            return 0;
    }
}
