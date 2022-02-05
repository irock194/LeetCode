package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/top-k-frequent-elements/

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
    Arrays.sort(nums);
    int previousValue = 0;
    int count = 0;
    int size = 0;
    for(int i = 0; i < nums.length; i++){
        if(i == 0){
            previousValue = nums[i];
        }
        else if(previousValue != nums[i]){
            size++;
            previousValue = nums[i];
        }
    }
    size++;
    int[][] answer = new int[size][2];
    size = 0;
    for(int i = 0; i < nums.length; i++){
        if(i == 0){
            previousValue = nums[i];
            count++;
        }
        else if(previousValue != nums[i]){
            answer[size][0] = count;
            answer[size][1] = previousValue;
            previousValue = nums[i];
            count = 1;
            size++;
        }
        else{
            count++;
        }
    }
    answer[size][0] = count;
    answer[size][1] = previousValue;
    
    Arrays.sort(answer, (a,b)-> b[0] - a[0]);

    int[] ans = new int[k];
    for(int i = 0; i < k; i++){
        ans[i] = answer[i][1];
    }
    
    return ans;
}
	
}
