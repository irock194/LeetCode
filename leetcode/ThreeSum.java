package leetcode;

import java.util.*;


public class ThreeSum {
	
    public List<List<Integer>> threeSum(int[] nums) {
        
        //sorting
        Arrays.sort(nums);
        int left;
        int right;
        int currentSum;
        
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < nums.length - 2; i++)
        {
            //continue if the value is the same as the previous value.
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            left = i + 1;
            right = nums.length - 1;
            
            while(left < right)
            {
                currentSum = nums[i] + nums[left] + nums[right];
                
                if(currentSum == 0)
                {
                    ArrayList<Integer> toAdd = new ArrayList<Integer>();
                    toAdd.add(nums[i]);
                    toAdd.add(nums[left]);
                    toAdd.add(nums[right]);
                    answer.add(toAdd);
                    
                    //continue if next element is a duplicate
                    while(left < right && nums[left] == nums[left + 1])
                        left++;
                    //continue if next element is a duplicate
                    while(left < right && nums[right] == nums[right - 1])
                        right--;
                    
                    left++;
                    right--;
                }
                else if(currentSum < 0)
                    left++;
                else if(currentSum > 0)
                    right--;
            }
        }
          
        return answer;
    }
	
	/***Brute force O(n^3)
    public List<List<Integer>> threeSum(int[] nums) {
        
        int size = nums.length;
        if(size <= 2)
        {
            ArrayList<List<Integer>> solution = new ArrayList<List<Integer>>();
            return solution;
        }
        
        HashSet<List<Integer>> solutions = new HashSet<List<Integer>>();
        
        for(int i = 0; i < size - 2; i++)
        {
            for(int j = i + 1; j < size - 1; j++)
            {
                for(int k = j + 1; k < size; k++)
                {
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                        ArrayList<Integer> toAdd = new ArrayList<Integer>();
                        
                        if(nums[i] <= nums[j] && nums[i] <= nums[k])
                        {
                            if(nums[j] < nums[k])
                            {
                                toAdd.add(nums[i]);
                                toAdd.add(nums[j]);
                                toAdd.add(nums[k]);
                            }
                            else
                            {
                                toAdd.add(nums[i]);
                                toAdd.add(nums[k]);
                                toAdd.add(nums[j]);
                            }
                                
                        }
                        else if(nums[j] <= nums[i] && nums[j] <= nums[k])
                        {
                            if(nums[i] < nums[k])
                            {
                                toAdd.add(nums[j]);
                                toAdd.add(nums[i]);
                                toAdd.add(nums[k]);
                            }
                            else
                            {
                                toAdd.add(nums[j]);
                                toAdd.add(nums[k]);
                                toAdd.add(nums[i]);
                            }
                                
                        }
                        else
                        {
                            if(nums[i] < nums[j])
                            {
                                toAdd.add(nums[k]);
                                toAdd.add(nums[i]);
                                toAdd.add(nums[j]);
                            }
                            else
                            {
                                toAdd.add(nums[k]);
                                toAdd.add(nums[j]);
                                toAdd.add(nums[i]);
                            }
                        }
                        
                        solutions.add(toAdd);
                    }
                }
            }
        }
        
        return new ArrayList<List<Integer>>(solutions);
    }
		***/
}
