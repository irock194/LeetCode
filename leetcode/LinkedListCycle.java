package leetcode;

import java.util.HashSet;

import leetcode.Solution.ListNode;

//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
	
	//log(n)
    public boolean hasCycle(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow)
            {
                return true;
            }
        }
        
        return false;
    }

	/***** O(n log n)
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null)
            return false;
        
        if(head.next == head)
            return true;
        
        HashSet<ListNode> nodes = new HashSet<ListNode>();
        ListNode currentNode = head;
        
        while(currentNode.next != null)
        {
            if(nodes.contains(currentNode.next))
            {
                return true;
            }
            
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }
        
        return false;
        
    }
    **/
}
