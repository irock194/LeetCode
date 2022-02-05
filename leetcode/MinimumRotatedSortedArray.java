package leetcode;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int min = Integer.MAX_VALUE;
        
        while(left <= right)
        {
            mid = left + (right - left) / 2;
            min = Math.min(Math.min(nums[mid], nums[right]), min);
            
            if(min == nums[mid])
                right = mid - 1;
            else if(min == nums[right])
                left = mid + 1;
            else
                return min;
        }
        
        return min;
    }
}
