package leetcode;

//https://leetcode.com/problems/container-with-most-water/
public class MostWaterVolume {

    public int maxArea(int[] height) {
        
        int maxVolume = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        int volume;
        
        while(left < right)
        {
            volume = Math.min(height[left], height[right]) * (right - left);
            
            maxVolume = Math.max(volume, maxVolume);
            
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        
        return maxVolume;
    }
}
