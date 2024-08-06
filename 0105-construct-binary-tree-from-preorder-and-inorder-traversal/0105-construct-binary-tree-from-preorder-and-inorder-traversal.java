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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        //map to store indices of inorder elements
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i =0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        //recursive construction
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);

    }
    private TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd,
    int[] inorder, int inorderStart, int inorderEnd,
    Map<Integer, Integer> inorderIndexMap){
        //base case
        if(preorderStart > preorderEnd || inorderStart > inorderEnd){
            return null;
        }

        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInorder = inorderIndexMap.get(rootValue);

        int leftSubtreeSize = rootIndexInorder - inorderStart;

        root.left = buildTreeHelper(preorder, preorderStart + 1, preorderStart + leftSubtreeSize,
        inorder, inorderStart, rootIndexInorder - 1, inorderIndexMap);

        root.right = buildTreeHelper(preorder, preorderStart + leftSubtreeSize + 1, preorderEnd,
        inorder, rootIndexInorder + 1, inorderEnd, inorderIndexMap);
        return root;
    }
}