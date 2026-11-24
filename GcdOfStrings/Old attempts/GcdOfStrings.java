class GcdofStringsSolution {
    
    public static void main (String args[])
    {
        System.out.println ( gcdOfStrings("ABABAB","ABAB") );
        System.out.println("Run completed.");
    }

    public static String gcdOfStrings(String str1, String str2) {

        // Check lengths if str1 length is divisible by str2 length
        int divpointer;
        String divisor = str2;
        String targetStr1Substring;
        String targetStr2Substring;

        divpointer = 0;
 
        while (divpointer + divisor.length()-1 <= str1.length())
        {
            //Temp code check
            System.out.println("String 1 Loop from "+divpointer);
            targetStr1Substring = str1.substring(divpointer,  divpointer+divisor.length());
            if (targetStr1Substring.equals(divisor))
            {
                divpointer = divpointer + divisor.length(); //Move divpointer to the start of the next substring to be checked.
            }
            else
            {
                if (!divisor.equals(""))
                divisor = divisor.substring(0,divisor.length()-1); //Might be naive (won't cover other edge cases?)
                else
                break;
            }
        }
        
        divpointer = 0;
        //Check String 2 divisibility
            
        while(divpointer + divisor.length()-1 <= str2.length())
        {
            //Temp code check
            System.out.println("String 2 Loop from "+divpointer);
            targetStr2Substring = str2.substring(divpointer,  divpointer+divisor.length());
            if (targetStr2Substring.equals(divisor))
            {
                divpointer = divpointer + divisor.length(); //Move divpointer to the start of the next substring to be checked.
            }
            else
            {
                if (!divisor.equals(""))
                divisor = divisor.substring(0,divisor.length()-1); //Might be naive (won't cover other edge cases?)
                else
                break;
            }
        }
        return divisor;
    }
    

}