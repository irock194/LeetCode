package leetcode;

import java.util.TreeMap;

//https://leetcode.com/problems/sliding-window-maximum/

public class SlidingWindowMaximum {
	
	//using TreeMap O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> dictionary = new TreeMap<Integer, Integer>();
        for(int i = 0; i < k; i++){
            dictionary.put(nums[i], dictionary.getOrDefault(nums[i], 0) + 1);
        }
        int[] answer = new int[nums.length + 1 - k];
        int start = 0;
        answer[start] = dictionary.lastKey();
        dictionary.put(nums[start], dictionary.get(nums[start]) - 1);
        if(dictionary.get(nums[start]) == 0){
            dictionary.remove(nums[start]);
        }    
        start++;	
        
        for(int i = k; i < nums.length; i++){
            dictionary.put(nums[i], dictionary.getOrDefault(nums[i], 0) + 1);
            answer[start] = dictionary.lastKey();
            dictionary.put(nums[start], dictionary.get(nums[start]) - 1);
            if(dictionary.get(nums[start]) == 0){
                dictionary.remove(nums[start]);
            }   
            start++;
        }
        
        return answer;
    }
	/****brute force. O(n^2)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = k - 1;
        int currentLargest = nums[0];
        int positionOfLargest = 0;
        int[] answer = new int[nums.length + 1 - k];
        int answerCount = 0;
        for(int i = 0; i < k; i++){
            if(currentLargest <= nums[i]){
                currentLargest = nums[i];
                positionOfLargest = i;
            }
        }
        
        answer[answerCount] = currentLargest;
        answerCount++;
        start++;
        end++;
        while(end != nums.length){
            if(currentLargest <= nums[end]){
                currentLargest = nums[end];
                positionOfLargest = end;
            }
            if(positionOfLargest < start){
                positionOfLargest = FindNewLargestPosition(nums, start, end);
                currentLargest = nums[positionOfLargest];
            }
            
            answer[answerCount] = currentLargest;
            answerCount++;
            start++;
            end++;
        }
        
        return answer;
    }
    
    int FindNewLargestPosition(int[] nums, int start, int end){
        int currentLargest = nums[start];
        int positionOfLargest = start;
        for(int i = start; i < end + 1; i++){
            if(currentLargest <= nums[i]){
                currentLargest = nums[i];
                positionOfLargest = i;
            }
        }
        return positionOfLargest;
    }
	***/
}
