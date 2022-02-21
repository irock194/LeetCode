package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/

public class MedianFinder {
    
    PriorityQueue<Integer> right;
    PriorityQueue<Integer> left;
    

    public MedianFinder() {
        right = new PriorityQueue<Integer>();
        left = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(right.size() == 0 && left.size() == 0){
            right.add(num);
            return;
        }
        if(right.peek() > num){
            left.add(num);
        }
        else{
            right.add(num);
        }
        //reorganize queues if left or right is greater than each other
        if(left.size() == right.size() + 2){
            right.add(left.poll());
        }
        else if(right.size() == left.size() + 2){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size() + 1){
            return left.peek();
        }
        if(right.size() == left.size() + 1){
            return right.peek();
        }
        return ((double)left.peek() + (double)right.peek()) / 2;
        
    }
}
