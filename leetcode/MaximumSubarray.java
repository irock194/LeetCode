package leetcode;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
	
	//O(n)
    public int maxSubArray(int[] nums) {
        
        int arrayLength = nums.length;
        int highest = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for(int i = 0; i < arrayLength; i++)
        {
            currentSum += nums[i];
            highest = Math.max(highest, currentSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        
        return highest;
    }
}
