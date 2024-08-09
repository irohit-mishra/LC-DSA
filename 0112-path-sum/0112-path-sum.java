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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //base case
        if(root == null){
            return false;
        }
        //if the current node is a leaf node, check if its value equals the target sum
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }

        int newTargetSum = targetSum - root.val;
        return hasPathSum (root.left, newTargetSum) || hasPathSum(root.right, newTargetSum);
    }
}