package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-of-three-numbers/
public class MaxProductOfThreeNumbers {

	//O(n log n) because of sorting.
    public int maximumProduct(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length - 1;
        
        return Math.max(nums[n] * nums[n - 1] * nums[n - 2], nums[0] * nums[1] * nums[n]);
          
    }
    
    /**** O(n)
     *     public int maximumProduct(int[] nums) {
     
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
          
        for(int i = 0; i < nums.length; i++)
        {
            if(min1 > nums[i])
            {
                min2 = min1;
                min1 = nums[i];
            }
            else if(min2 > nums[i])
                min2 = nums[i];
            
            if(max1 < nums[i])
            {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(max2 < nums[i])
            {
                max3 = max2;
                max2 = nums[i];
            }
            else if(max3 < nums[i])
                max3 = nums[i];
        }
        
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
     */
}
