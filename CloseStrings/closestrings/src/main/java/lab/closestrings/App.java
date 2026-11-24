package lab.closestrings;

/**
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Run completed." );
    }

    public static boolean closeStrings(String word1, String word2) 
    {
        if (word1.length() != word2.length())
            return false;
        else
            //load word1 into a hashset.
            char[] tokenizedWord1 = word1.toCharArray();
            HashSet<Character> word1Set = new HashSet<Character>();
            for (Character c : tokenizedWord1)
            {
                set.add(c);           
            }
    }
}
