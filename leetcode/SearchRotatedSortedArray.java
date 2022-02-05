package leetcode;


//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchRotatedSortedArray {
	
	// O(log n)
    public int search(int[] nums, int target) {
        
        int mid = (nums.length - 1) / 2;
        if(nums[mid] == target)
            return mid;
        
        if(nums[mid] - nums[0] > 0)
            return Math.max(normalBinarySearch(nums, target, 0, mid - 1), inverseBinarySearch(nums, target, mid + 1, nums.length - 1));
        else
            return Math.max(inverseBinarySearch(nums, target, 0, mid - 1), normalBinarySearch(nums, target, mid + 1, nums.length - 1));
    }
    
    int normalBinarySearch(int[] nums, int target, int left, int right)
    {
        if(right >= left)
        {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target)
                return mid;
            
            if(nums[mid] > target)
                return normalBinarySearch(nums, target, left, mid - 1);
            
            return normalBinarySearch(nums, target, mid + 1, right);
        }
        
        return -1;
    }
    
    int inverseBinarySearch(int[] nums, int target, int left, int right)
    {
        if(right >= left)
        {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target)
                return mid;
            if(mid == left)
            {
                if(nums[right] == target)
                    return right;
                else
                    return -1;
            }
            
            if(nums[mid] - nums[left] > 0)
            {
                return Math.max(normalBinarySearch(nums, target, left, mid - 1), inverseBinarySearch(nums, target, mid + 1, right));                
            }
            else
            {
                return Math.max(inverseBinarySearch(nums, target, left, mid - 1), normalBinarySearch(nums, target, mid + 1, right));
            }
        }
        
        return -1;   
    }

}
