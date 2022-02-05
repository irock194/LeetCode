package leetcode;

import java.util.HashSet;


//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicates {

	//O(n)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> previousValues = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(previousValues.contains(nums[i]))
                return true;
            previousValues.add(nums[i]);
        }
        return false;
    }
}
