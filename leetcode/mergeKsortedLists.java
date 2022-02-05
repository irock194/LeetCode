package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        
        ListNode currentHead = mergeTwoLists(lists[0], lists[1]);
        for(int i = 2; i < lists.length; i++)
        {
            currentHead = mergeTwoLists(currentHead, lists[i]);
        }
        
        return currentHead;
    }
    
    ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode head;
        
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        else if(list1 == null && list2 == null)
            return null;
        
        if(list1.val < list2.val)
        {
            head = list1;
            list1 = list1.next;
        }
        else
        {
            head = list2;
            list2 = list2.next;
        }
        
        ListNode mainList = head;
        
        while(list1 != null || list2 != null)
        {
            if(list1 == null)
            {
                mainList.next = list2;
                mainList = mainList.next;
                list2 = list2.next;
            }
            else if(list2 == null)
            {
                mainList.next = list1;
                mainList = mainList.next;
                list1 = list1.next;
            }
            else if(list1.val < list2.val)
            {
                mainList.next = list1;
                mainList = mainList.next;
                list1 = list1.next;
            }
            else
            {
                mainList.next = list2;
                mainList = mainList.next;
                list2 = list2.next;
            }

        }
        
        
        return head;
    }
    
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
      
      /****Another version
       *     public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];

        ArrayList<Integer> allValues = new ArrayList<Integer>();
        ListNode currentNode;
        
        for(int i = 0; i < lists.length; i++)
        {
            currentNode = lists[i];
            while(currentNode != null)
            {
                allValues.add(currentNode.val);
                currentNode = currentNode.next;
            }
        }
        
        Collections.sort(allValues);
        
        if(allValues.size() == 0)
            return null;
        
        ListNode head = new ListNode(allValues.get(0));
        currentNode = head;
        
        for(int i = 1; i < allValues.size(); i++)
        {
            currentNode.next = new ListNode(allValues.get(i));
            currentNode = currentNode.next;
        }
        
        return head;
    }
       */
     
}