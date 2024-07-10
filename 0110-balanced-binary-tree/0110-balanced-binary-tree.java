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
 //Balanced height tree: the difference in height between the left and right subtrees is at most 1.
class Solution {
    public boolean isBalanced(TreeNode root) {
     return checkHeight(root)!= -1;   
    }

    private int checkHeight (TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = checkHeight (node.left);
        if(leftHeight == -1) return -1; //left subtree is not balanced 

        int rightHeight = checkHeight(node.right);
        if(rightHeight == -1) return -1; //right subtree is not balanced

        if(Math.abs(leftHeight - rightHeight)> 1){
            return -1; //current node is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1; //return the Height of the rooted at this node
    }
}