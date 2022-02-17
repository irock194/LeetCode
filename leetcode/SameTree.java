package leetcode;

import leetcode.ValidateBinarySearchTree.TreeNode;

//https://leetcode.com/problems/same-tree/

public class SameTree {
	
	//O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return searchTree(p, q);
    }
    
    boolean searchTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return searchTree(p.left, q.left) && searchTree(p.right, q.right);
    }
}
