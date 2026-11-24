package lab.mergesort;

/**
 * Hello world!
 *
 */
public class MergeSort 
{
    public static void main( String[] args )
    {
        int first, last;
        first = 0; //index of the first element in the array
        int[] arr = {4567,345,29,6,789,10};
        last = arr.length-1; //get index of last element

        mergeSort(arr, first, last);

        printArrayContents(arr);
    }

    public static void mergeSort(int[] msArr,int msFirst, int msLast)
    {
        int msMid;
        //Find the midpoint of the array.
        msMid = determineMid(msFirst, msLast);

        //Divide the input array into subarrays recursively until elements are divided into single element arrays.
        if (msFirst < msLast)
        {
            //Create subarray for the first half (indices: first element = msFirst, last element is the middle element of the array = msMid + 1)
            mergeSort(msArr, msFirst, msMid); 

            //Create subarray for the second half (indices: first element = element after calculated midpoint of the array, last element = last element of the array )
            mergeSort(msArr,msMid+1, msLast);

            //Call the merge function to compare and sort the values in the array from largest to smallest.
            merge(msArr, msFirst, msMid, msLast);
        }
    }

    public static void merge(int[] mArr,int mFirst, int mMid, int mLast)
    {
        //Declare indices and lengths of temporary arrays
        int leftPointer, rightPointer, mergePointer;
        int arr1Length = setLeftArrayLength(mFirst,mMid);
        int arr2Length = setRightArrayLength(mMid, mLast);

        //Declare temporary arrays
        int[] leftArray = new int[arr1Length]; 
        int[] rightArray = new int[arr2Length];

        //Populate arrays with elements from the parent array
        for (int i = 0; i < arr1Length; i++)
        {
            leftArray[i] = mArr[mFirst+i];
        }

        for (int j = 0; j < arr2Length; j++)
        {
            rightArray[j] = mArr[mMid+1+j];

            //TODO: What is making us go out of bounds here? I set the array length to the wrong size.....
        }

        //Initialize pointer variables
        leftPointer = 0; //starting index of the left pointer
        rightPointer = 0; //starting index of the right pointer
        mergePointer = mFirst; //starting index of the merged Array

        //Compare leftmost elements in leftArray and rightArray
        while(leftPointer < arr1Length && rightPointer < arr2Length)
        {
            //If the value in the leftArray is smaller than the one in the rightArray, insert the leftArray value into the merged array.
            //Otherwise, insert the value in the rightArray.
            //ergo, insert the lower value between the two arrays into the merged Array.
            if(leftArray[leftPointer] <= rightArray[rightPointer])
            {
                mArr[mergePointer] = leftArray[leftPointer];
                leftPointer++;

            }
            else
            {
                mArr[mergePointer] = rightArray[rightPointer];
                rightPointer++;
            }
            mergePointer++;
        }
        
            //insert sorted values into the parent array, then increment pointers to the next values to be sorted.
            while (leftPointer < arr1Length)
            {
                mArr[mergePointer]  = leftArray[leftPointer];
                leftPointer++;
                mergePointer++;
            }

            while(rightPointer < arr2Length)
            {
                mArr[mergePointer]  = rightArray[rightPointer];
                rightPointer++;
                mergePointer++;
            }
        

        printArrayContents(mArr);

        
    }


// Small formula-based setters
    public static int determineMid(int dFirst, int dLast)
    {
        return (dFirst + dLast)/2;
    }

    public static int setLeftArrayLength(int sFirst,int sMid)
    {
        return sMid - sFirst + 1;
    }

    public static int setRightArrayLength(int sMid, int sLast)
    {
        return sLast - sMid;
    }

//Getters

    public static void printArrayContents(int[] targetArr)
    {
        System.out.println("Array Contents:");
        for( int i = 0; i < targetArr.length; i++)
        {
            
            System.out.print(targetArr[i]+"  ");
        }
        System.out.println("\n End Print.");
    }

}
