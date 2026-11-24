package lab.arrayproduct2;


public class ArrayProduct2 
{
    public static void main( String[] args )
    {
        int[] inputArray = {1,2,3,4};
        int[] outputArray = productExceptSelf2(inputArray);
        printArray(outputArray);
        System.out.println( "Run completed." );
    }

    public static int[] productExceptSelf2(int[] nums)
    {
        int[] answer = new int[nums.length];
        int prefix,suffix;

        //Calculate prefix products for each element and store them in the answer array.
        prefix = 1;
        for (int i = 0; i < answer.length; i++)
        {
            answer[i] = prefix;
            prefix = prefix * nums[i];
        }

        //Calculate suffix products for each element, multiply them with the prefix products currently stored in the answer array.
        suffix = 1;
        for (int i = answer.length-1; i >= 0; i--)
        {
            answer[i] = answer [i] * suffix;
            suffix = suffix * nums[i];
        }

        return answer;
    }

    public static void printArray(int[] targetArray)
    {
        for (int i : targetArray)
        {
            System.out.println(i);
        }
    }
}
