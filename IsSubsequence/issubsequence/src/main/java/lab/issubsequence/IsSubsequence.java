package lab.issubsequence;

/**
 *
 */
public class IsSubsequence 
{
    public static void main( String[] args )
    {
        String inputS = "axc";
        String inputT = "ahbgdc";
        System.out.println(isSubsequence(inputS, inputT));
        System.out.println("Run completed.");
    }

    public static boolean isSubsequence(String s, String t)
    {
        char[] sTokens = s.toCharArray();
        char[] tTokens = t.toCharArray();

        int sPointer, tPointer;
        sPointer = 0;
        tPointer = 0;

        while( tPointer < tTokens.length && sPointer < sTokens.length)
        {
            if (tTokens[tPointer] == sTokens[sPointer])
                sPointer ++;
            
            tPointer ++;
        }

        if (sPointer == sTokens.length)
            return true;
        else
            return false;
    }
}
