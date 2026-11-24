package lab.stringcompression;

/**
 *
 */
public class StringCompression 
{
    public static void main( String[] args )
    {
        char[] inputArray = {'a','a','b','b','b','a','a','a','a'};
        int returnLength;
        returnLength = compress(inputArray);
        System.out.println(returnLength);
        System.out.println( "Run completed." );
    }

    public static int compress(char[] chars)
    {
        String outputString;
        int startIndex, lastIndex;
        
        outputString = "";
        startIndex = 0;

        while(startIndex < chars.length)
        {
            lastIndex = startIndex;
            
            //Traverse the current group in the char array.

            while(lastIndex < chars.length && chars[startIndex] == chars[lastIndex])
            {
                    lastIndex++;
            }

            //If there is only 1 character of the current group, do not compress.
            if ((lastIndex - 1) == startIndex)
            {
                outputString = outputString + chars[startIndex];
            }
            //If there is more than 1 character of the current group, create the compressed string.
            else
            {
                outputString = outputString + chars[startIndex] + (lastIndex - startIndex);
            }
            
            startIndex = lastIndex;
        }

         //Insert the outputString into the input char array.
         for (int i = 0; i < outputString.length(); i++)
         {
             chars[i] = outputString.charAt(i);
         }
        System.out.println(outputString);
        return outputString.length();

    }

    public static void printArray (String[] targetArray)
    {
        for (String i : targetArray)
        {
            System.out.println( i );
        }
    }
}
