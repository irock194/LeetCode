package leetcode;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

import java.util.HashSet;

import leetcode.ValidateBinarySearchTree.TreeNode;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> values = new HashSet<Integer>();
        return traverseBST(root, k, values);
    }
    
    boolean traverseBST(TreeNode root, int k, HashSet<Integer> values){
        if(root == null){
            return false;
        }
        if(values.contains(k - root.val)){
            return true;
        }
        values.add(root.val);
        return traverseBST(root.left, k, values) || traverseBST(root.right, k , values);
    }
}
