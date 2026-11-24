package lab.reversevowels;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class ReverseVowels 
{
    public static void main( String[] args )
    {
        String target = "aA";
        System.out.println(target);
        String result = runReverseVowels(target);
        System.out.println(result);
        System.out.println( "Run completed" );
    }

    public static String runReverseVowels(String s)
    {
        ArrayList<String> tokenizedString = new ArrayList<String>();
        ArrayList<String> vowelStack = new ArrayList<String>();
        ArrayList<Integer> indexQueue = new ArrayList<Integer>();
        String[] vowels = {"a","e","i","o","u","A","E","I","O","U"};
        String result = "";

        //Tokenize String. Store tokenized string into an ArrayList
        tokenizedString = tokenizeString(s);

        //Traverse tokenized string and add vowels to a stack, and add their indices into a queue.
        for (int i=0; i < tokenizedString.size(); i++ )
        {
            for (int j=0; j < vowels.length; j++)
            {
                if(tokenizedString.get(i).equals(vowels[j]))
                {
                    vowelStack.add(tokenizedString.get(i));
                    indexQueue.add(i);
                }
            }
        }

        //Modify tokenized string to reverse vowels:
        //Traverse index queue from last element to first element,
        //and insert vowels from the vowel stack from the first element to the last element.

        int vowelPointer = 0; // pointer for vowel stack
        int indexPointer = indexQueue.size()-1; //pointer for pointer queue. Must point to last index in ArrayList.

        while (indexPointer >= 0 && vowelPointer < vowelStack.size())
        {
            tokenizedString.set(indexQueue.get(indexPointer),vowelStack.get(vowelPointer));

            vowelPointer++;
            indexPointer--;
        }

        //Output modified tokenizedString
        for(String c: tokenizedString)
        {
            result = result + c;
        }

        return result;
    }

    public static ArrayList<String> tokenizeString(String targetString)
    {
        ArrayList<String> tokenizedTargetString = new ArrayList<String>();

        for (int i = 0; i<targetString.length();i++)
        {
            tokenizedTargetString.add(i,targetString.substring(i,i+1)); 
        }

        return tokenizedTargetString;
    }

}
