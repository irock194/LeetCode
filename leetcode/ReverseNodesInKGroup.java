package leetcode;

import java.util.ArrayList;

import leetcode.Solution.ListNode;

//https://leetcode.com/problems/reverse-nodes-in-k-group/

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        ListNode startOfChain = null;
        ListNode currentNode = head;
        ListNode newHead = null;
        ListNode newNodes = null;
        boolean isFirstHead = false;
        ListNode startOfList = head;
        
        int count = 0;
        while(currentNode != null){
            if(count == k){
                //Collections.reverse(values);
                for(int i = values.size() - 1; i > -1; i--){
                    if(i == values.size() - 1){
                        newNodes = new ListNode(values.get(i));
                        newHead = newNodes;
                        continue;
                    }
                    newNodes.next = new ListNode(values.get(i));
                    newNodes = newNodes.next;
                }
                values.clear();  //maybe remove all elements
                if(startOfChain != null){
                    startOfChain.next = newHead;
                }
                startOfChain = newNodes;
                if(!isFirstHead){
                    startOfList = newHead;
                    isFirstHead = true;
                }
                count = 0;
            }
            values.add(currentNode.val);
            currentNode = currentNode.next;
            count++;
        }
        if(count == k){
            //Collections.reverse(values);
            if(!values.isEmpty()){
                if(startOfChain != null){
                    for(int i = values.size() - 1; i > -1; i--){
                        startOfChain.next = new ListNode(values.get(i));
                        startOfChain = startOfChain.next;
                    }
                }
                else{
                    for(int i = values.size() - 1; i > -1; i--){
                        if(i == values.size() - 1){
                            startOfList = new ListNode(values.get(i));
                            newNodes = startOfList;
                            continue;
                        }
                        newNodes.next = new ListNode(values.get(i));
                        newNodes = newNodes.next;
                    }
                }
            }
        }
        else{
            if(!values.isEmpty()){
                if(startOfChain != null){
                    for(int i = 0; i < values.size(); i++){
                        startOfChain.next = new ListNode(values.get(i));
                        startOfChain = startOfChain.next;
                    }
                }
                else{
                    for(int i = 0; i < values.size(); i++){
                        if(i == 0){
                            startOfList = new ListNode(values.get(i));
                            newNodes = startOfList;
                            continue;
                        }
                        newNodes.next = new ListNode(values.get(i));
                        newNodes = newNodes.next;
                    }
                }
            }
        }
        
        
        return startOfList;
        
    }

}
