/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val){
        this.val = val;
        left = null;
        right = null;
    }
 }
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long low, long high){
        //an empty tree is valid BST
        if(node == null){
            return true;
        }
        //the current node's value must be within the range defined by low and high
        if(node.val <= low || node.val >= high){
            return false;
        }
        //recursivey validate the left and right subtrees with updated ranges
        return validate(node.left, low, node.val) && validate (node.right, node.val, high);
    }
}