package leetcode;

import java.util.HashMap;


//https://leetcode.com/problems/two-sum/
public class TwoSum {

	//O(n)
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }
        int possibleSolutionKey;
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                possibleSolutionKey = map.get(target - nums[i]);
                if(i != possibleSolutionKey)
                {
                    int[] arr = {i, possibleSolutionKey};
                    return arr;
                }
            }
        }
        
        int[] notFound = {};
        return notFound;
        
    }
    /******O(n^2)
     *     public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    int[] answer = {i, j};
                    return answer;
                }
            }
        }
        
        return null;
    }
     */
}
