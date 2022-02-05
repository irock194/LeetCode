package leetcode;

import leetcode.Solution.ListNode;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkList {

	
	//O(n)
    public ListNode reverseList(ListNode head) {
        
        ListNode currentNode = head;
            
        if(head == null || head.next == null)
            return head;
        
        ListNode nextNode = currentNode.next;
        ListNode secondNextNode;
        ListNode tempNode;
        currentNode.next = null;
        
        while(nextNode.next != null)
        {
            secondNextNode = nextNode.next;
            nextNode.next = currentNode;
            tempNode = nextNode;
            nextNode = secondNextNode;
            currentNode = tempNode;
        }
        
        nextNode.next = currentNode;
        
        return nextNode;
    }
}
