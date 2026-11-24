package lab.diffoftwoarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class DifferenceOfTwoArrays 
{
    public static void main( String[] args )
    {
        int[] inputNums1 = {1,1,3,3};
        int[] inputNums2 = {1,1,2,2};
        List<List<Integer>> output = findDifference(inputNums1, inputNums2);
        System.out.println(output);
        System.out.println( "Run completed." );
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2){
        /*
        
        //Slower Implementation

        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        //convert int arrays to Integer sets
        List<Integer> nums1List = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> nums2List = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        
        //Create the first list element for answers. Check if the elements in nums1List are in nums2List. If it is not, store it in the list
        answer.add(0,new ArrayList<Integer>());
        nums1List.stream().forEach(
            n -> 
            {
                if (nums2List.contains(n) == false && answer.get(0).contains(n) == false) 
                    answer.get(0).add(n);
            });
        
        //Create the second list element for answer. Check if the elements in nums2List are in nums1List. If it is not, store it in the list
        answer.add(1,new ArrayList<Integer>());
            nums2List.stream().forEach(
                n ->
                {
                    if (nums1List.contains(n) == false && answer.get(1).contains(n) == false)
                    answer.get(1).add(n);
                });

        return answer;  */

        //Faster Implementation obtained from Solutions tab

        Set<Integer> set1 = new HashSet<>();                           // create 2 hashsets
		Set<Integer> set2 = new HashSet<>();
		for(int num : nums1){ set1.add(num); }                         // add nums1 elements to set1
		for(int num : nums2){ set2.add(num); }                         // add nums2 elements to set2
		
		List<List<Integer>> resultList = new ArrayList<>();             // Initialize result list with 2 empty sublists that we will return
		resultList.add(new ArrayList<>());
		resultList.add(new ArrayList<>());

		for(int num : set1){                                            // just iterate to all elements of set1
			if(!set2.contains(num)){ resultList.get(0).add(num); }      // add those elements to first sublist of result list, which are not in set2.
		}
		for(int num : set2){                                            // just iterate to all elements of set2
			if(!set1.contains(num)){ resultList.get(1).add(num); }      // add those elements to first sublist of result list, which are not in set1
		}
		return resultList;
    }
}
