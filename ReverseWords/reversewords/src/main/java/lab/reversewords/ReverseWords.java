package lab.reversewords;

/**
 * Hello world!
 *
 */
public class ReverseWords 
{
    public static void main( String[] args )
    {
        String inputString = "blue  ";
        String outputString;

        outputString = runReverseWords(inputString);
        System.out.println(outputString);
        System.out.println( "Run completed." );
    }

    public static String runReverseWords(String s)
    {
        char[] tokenizedString = s.toCharArray();
        int inputStringPointer = tokenizedString.length-1; // Will traverse the input string and stop when it reads in a space. Initialize to the last index of the tokenized String.
        int reversedStringPointer = 0; //Will check whether there is a word and will read in words.
        String spaceChar = " ";
        String tempWord;
        String result = "";

        //Traverse tokenized String until the pointer finds a space or reaches the start of the String.
        while(inputStringPointer >= 0)
        {
            while(inputStringPointer >= 0 && Character.toString(tokenizedString[inputStringPointer]).indexOf(spaceChar) == -1)
            {
                inputStringPointer--;
            }

            //set starting index to the index before the space.
            reversedStringPointer = inputStringPointer + 1;

            //Initialize tempWord to blank in prep to read in any traversed word
            tempWord = "";

            //When the input string pointer finds a space, use the reverse string pointer to check whether a word was traversed.
            // If a word was traversed, read it in and concatenate it to the result string.
            while(reversedStringPointer < tokenizedString.length && Character.toString(tokenizedString[reversedStringPointer]).indexOf(spaceChar) != 0)
            {

                //If there is a non-space character, concatenate it to tempWord.
                tempWord = tempWord + Character.toString(tokenizedString[reversedStringPointer]);
                //move the pointer forward
                reversedStringPointer++;
            }

            //Check if any characters were concatenated to tempWord. If there was a word and not an adjacent empty space, concatenate to the result reversed string with a space.
            if(tempWord.length() > 0)
            {
                result = result + tempWord + " "; 
            }
            
            //Move the input string pointer
            inputStringPointer--;
        }

        return result.trim();

    }
}
