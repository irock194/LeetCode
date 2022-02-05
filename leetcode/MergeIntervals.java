package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
	
	//My version of solution O(n log(n))
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        int[][] temp = new int [intervals.length][intervals[0].length];
        int currentStart = 0;
        int currentEnd = 0;
        int arrayIndex = 0;
        
        if(intervals.length == 1)
            return intervals;
        
        for(int i = 0; i < intervals.length; i++)
        {
            if(i == 0)
            {
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
                continue;
            }
            
            if(currentStart > intervals[i][0])
            {
                currentStart = intervals[i][0];
            }
            if(currentEnd < intervals[i][0])
            {
                temp[arrayIndex][0] = currentStart;
                temp[arrayIndex][1] = currentEnd;
                arrayIndex++;
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            }
            else if(currentEnd < intervals[i][1])
            {
                currentEnd = intervals[i][1];
            }
            
            if(i == intervals.length - 1)
            {
                temp[arrayIndex][0] = currentStart;
                temp[arrayIndex][1] = currentEnd;
                arrayIndex++;
            }
        }
        int[][] answer = new int [arrayIndex][2];
        for(int i = 0; i < arrayIndex; i++)
        {
            answer[i][0] = temp[i][0];
            answer[i][1] = temp[i][1];
        }
        
        return answer;
    }
    
    /****** O(n log n) given answer, but my solution is faster
     *     public int[][] merge(int[][] intervals) {
        
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int []> merged = new LinkedList<>();
    for(int[] interval : intervals)
    {
        if(merged.isEmpty() || merged.getLast()[1] < interval[0])
            merged.add(interval);
        else
            merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
    }
        
    return merged.toArray(new int[merged.size()][]);
    }
     */
}
