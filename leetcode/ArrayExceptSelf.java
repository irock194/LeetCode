package leetcode;

//https://leetcode.com/problems/product-of-array-except-self/
public class ArrayExceptSelf {
	
	//O(n)
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int[] previousSum = new int[size];
        int[] afterSum = new int[size];
        
        for(int i = 0; i < size; i++)
        {
            if(i == 0)
            {
                previousSum[i] = 1;
                continue;
            }
            previousSum[i] = previousSum[i - 1] * nums[i - 1];
        }
        
        for(int i = size - 1; i >= 0; i--)
        {
            if(i == size -1)
            {
                afterSum[i] = 1;
                continue;
            }
            afterSum[i] = afterSum[i + 1] * nums[i + 1];
        }
        
        int [] answer = new int[size];
        
        for(int i = 0; i < size; i++)
        {
            answer[i] = previousSum[i] * afterSum[i];
        }
        
        return answer;
        
    }

}
