class Solution {

    public static void main (String args[])
    {
       mergeAlternately("abcd","xyz");
       System.out.println("Run completed.");
    }

    public static String mergeAlternately(String word1, String word2) {
    int i;
    String finalString;
    finalString = "";
    i = 0;

        while (i <= word1.length() || i <= word2.length())
        {
            if(i < word1.length())  
            {
                finalString = finalString.concat( Character.toString(word1.charAt(i)));
            }

            if(i < word2.length()) 
            {
                finalString = finalString.concat( Character.toString(word2.charAt(i)));
            }
            i++;
        }
        return finalString;
    }
}