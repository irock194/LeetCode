package leetcode;

import leetcode.Solution.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {
	
	//using two pointers O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        head = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null){
            fast = fast.next;
            if(n > 0){
                n--;
                continue;
            }
            if(fast == null){
                slow.next = slow.next.next;
            }
            slow = slow.next;
        }
        
        return head.next;
    }

	/**O(2n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode currentNode = head;
        int currentNumber = 1;
        int sizeOfList = 1;
        
        while(currentNode.next != null){
            currentNode = currentNode.next;
            sizeOfList++;
        }
        currentNode = head;
        if(sizeOfList == n){
            head = currentNode.next;
            return head;
        }
        
        while(currentNumber < sizeOfList - n){
            currentNode = currentNode.next;
            currentNumber++;
        }

        currentNode.next = currentNode.next.next;
        return head;
    }
    **/
}
