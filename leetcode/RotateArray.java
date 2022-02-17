package leetcode;

//https://leetcode.com/problems/rotate-array/

public class RotateArray {
	
	//O(n)
    public void rotate(int[] nums, int k) {
        int[] answer = new int[nums.length];
        int answerCount = 0;
        for(int i = nums.length - (k % nums.length); i < nums.length; i++){
            answer[answerCount] = nums[i];
            answerCount++;
        }
        for(int i = 0; i < nums.length - (k % nums.length); i++){
            answer[answerCount] = nums[i];
            answerCount++;
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = answer[i];
        }
        //(k % nums.length) + 1
    }
}
