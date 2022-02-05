package leetcode;

import leetcode.ValidateBinarySearchTree.TreeNode;

//https://leetcode.com/problems/invert-binary-tree/
public class InverseBinaryTree {

	//O(n)
    public TreeNode invertTree(TreeNode root) {
        invertBinaryTree(root);
        return root;
    }
    
    void invertBinaryTree(TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.left != null || root.right != null){
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        
        return;
    }
}
