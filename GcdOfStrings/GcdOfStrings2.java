//Passed as a solution to LeetCode 1071
class GcdOfStrings2
{
    public static void main (String args[])
    {
        System.out.println(gcdOfStrings2("ABABAB","ABAB"));
        System.out.println("Run completed.");
    }

    public static String gcdOfStrings2(String str1, String str2)
    {
        String greatestCommonDivisor;
        String divisor;
        int prefixLength;
        int DIVPOINTER;
        Boolean divisibilityFlag;

        //Initialize Variables
        greatestCommonDivisor = ""; 
        DIVPOINTER = 0; 
        prefixLength = DIVPOINTER + 1; //to be used in conjunction with divPointer and the substring method. Need to indicate index after the target index.
        divisor = "";
        divisibilityFlag = false;

        //Start loop with shortest possible string 2 prefix. End loop once maximum possible prefix has been iterated.
        do
        {
            //initialize divisor substring
            divisor = str2.substring(DIVPOINTER,prefixLength);

            //Check divisibility with string 1.
            for (int i = 0 ;i < str1.length() ; i = i + divisor.length()) //Start from index 0. End when starting index exceeds str1 length. increment to next index.
            {
                if(i + prefixLength > str1.length())
                {
                    divisibilityFlag = false;
                    break;
                }
                if (str1.substring(i,i + prefixLength).equals(divisor))
                {
                    divisibilityFlag = true;
                }
                else
                {
                    divisibilityFlag = false;
                    break;
                }
            }
            // If divisibilityFlag is still true and str1 was determined to be divisible by the current divisor, check divisibility for string 2.
            // If divisibilityFlag is false, skip checking string 2 and check the next prefix in the loop.
            if (divisibilityFlag)
            {
                for (int i = 0 ;i < str2.length() ; i = i + divisor.length())
                {
                    if(i + prefixLength > str2.length())
                    {
                        divisibilityFlag = false;
                        break;
                    }
                    if (str2.substring(i,i + prefixLength).equals(divisor))
                    {
                        divisibilityFlag = true;

                    }
                    else
                    {
                        divisibilityFlag = false;
                        break;
                    }
                }
            }
            //If divisibilityFlag is still true (Passed all check cases), set new greatest common divisor.
            if(divisibilityFlag)
            {
                greatestCommonDivisor = divisor;
            }
            //uptick prefix length. reiterate loop.
            prefixLength++;

        }
        while (prefixLength <= str2.length());
        return greatestCommonDivisor;
    }
}