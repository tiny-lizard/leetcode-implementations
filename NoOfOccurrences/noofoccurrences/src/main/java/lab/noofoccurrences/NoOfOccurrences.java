package lab.noofoccurrences;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 */
public class NoOfOccurrences 
{
    public static void main( String[] args )
    {
        int[] input = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(input));
        System.out.println( "Run completed." );
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurrences = new HashMap<Integer,Integer>();   
        
        //Loop through the array. If the current value exists as a key in the HashMap, increment that key's value. 
        //If it does not, add a key-value pair of (arrayElement, 1)
        for( int e : arr )
        {
            if (occurrences.containsKey(e))
                occurrences.replace(e, occurrences.get(e)+1);
            else
                occurrences.put(e,1);
        }
        
        //Loop through the hashmap. Set the current key-value pair's value into a temporary variable then remove the pair from the Hashmap.
        //Check if the value in the temporary value still exists in the HashMap. 
        //If it does, return false. If the loop finishes without returning false, return true.
        int currValue = 0;
        Iterator<Integer> it = occurrences.keySet().iterator();
        while(it.hasNext())
        {
            currValue = occurrences.get(it.next());
            it.remove();
            if (occurrences.containsValue(currValue))
            return false;
            
        }
        return true;
    }
}
