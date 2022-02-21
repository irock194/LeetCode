package leetcode;

import leetcode.ValidateBinarySearchTree.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class TreeDepth {
    public int maxDepth(TreeNode root) {
        return recursiveDepth(root, 0);
    }
    
    int recursiveDepth(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        depth++;
        return Math.max(recursiveDepth(root.left, depth), recursiveDepth(root.right, depth));
    }

}
