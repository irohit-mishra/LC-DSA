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
class Solution {
    private int diameter= 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        //helper method to calculate height and update diameter
        calculateHeight(root);
        return diameter;
    }

    private int calculateHeight (TreeNode node){
        if (node == null){
            return 0;
        }

        //recursively get the height of the left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        //update the diameter if the current path is longerthen the current
        diameter = Math.max(diameter, leftHeight + rightHeight);

        //retuen the height of the tree rooted at the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}