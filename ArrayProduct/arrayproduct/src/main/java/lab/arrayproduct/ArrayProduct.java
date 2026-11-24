package lab.arrayproduct;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * Hello world!
 *
 */
public class ArrayProduct 
{
    public static void main( String[] args )
    {
        int[] inputArray = {2,2,3,7};
        int[] outputArray = productExceptSelf(inputArray);
        printArrayContents(outputArray);
        System.out.println( "Run completed." );
    }

    public static int[] productExceptSelf(int[] nums)
    {
        int[] tempArray;
        int[] answer = new int[nums.length]; //Store final products in this array

        //Define a LongBinaryOperator for multiplication
        IntBinaryOperator multiply = (a,b) -> a*b;

        int currentIndex = 0; // Indicates current index being iterated upon in the array

        while(currentIndex < nums.length)
        {
            tempArray = Arrays.copyOf(nums,nums.length);
            //Perform multiplication on the prefix subarray of nums
            Arrays.parallelPrefix(tempArray,0,currentIndex,multiply);

            //Perform multiplication on the suffix subarray of nums. Reminder: fromIndex is inclusive, toIndex is exclusive
            Arrays.parallelPrefix(tempArray,currentIndex+1,tempArray.length,multiply);

            //Multiply the product of the prefix subarray to the product of the suffix subarray. Store the final product in answer[currentIndex]
            int prefixProduct = 1;
            int suffixProduct = 1;

            //Product of the prefix will always be stored in currentIndex-1. If currentIndex is 0, there is no prefix.
            if (currentIndex > 0)
                prefixProduct = tempArray[currentIndex-1];
            
            //Product of the suffix will always be stored in nums.length-1. If currentindex is the last index, there is no suffix.
            if (currentIndex < tempArray.length-1)
                suffixProduct = tempArray[tempArray.length-1];

            answer[currentIndex] = prefixProduct * suffixProduct;

            //Increment currentIndex
            currentIndex++;
        }

        return answer;

    }

    public static void printArrayContents(int[] targetArray)
    {
        for(int i : targetArray)
        {
            System.out.println(i);
        }
    }
}
