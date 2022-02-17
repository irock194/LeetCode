package leetcode;

//https://leetcode.com/problems/merge-sorted-array/

public class MergeTwoSortedArrays {
	
	//O(m + n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(k < m + n){
            if(i < m  && j < n){
                if(nums1[i] < nums2[j]){
                    nums[k] = nums1[i];
                    i++;
                }
                else{
                    nums[k] = nums2[j];
                    j++;
                }
            }
            else if(i < m){
                nums[k] = nums1[i];
                i++;
            }
            else{
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        for(int p = 0; p < nums.length; p++){
            nums1[p] = nums[p];
        }
    }
}
