package leetcode;

//https://leetcode.com/problems/sliding-window-maximum/

public class SlidingWindowMaximum {
	//brute force. O(n^2)
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

}
