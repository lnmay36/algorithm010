//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length==0)
            return null;//边界条件
        int rootVal = preorder[0];
        int rootIndex = 0;
        for (int i=0;i<inorder.length;++i) {
            if (inorder[i]==rootVal) {
                rootIndex = i;
                break;
            }
        }
        int[] pre_left = new int[rootIndex];
        int[] pre_right = new int[inorder.length - rootIndex-1];
        int[] in_left = new int[rootIndex];
        int[] in_right = new int[inorder.length - rootIndex-1];
        System.arraycopy(preorder, 1, pre_left, 0, rootIndex);
        System.arraycopy(preorder,rootIndex+1, pre_right, 0, inorder.length - rootIndex - 1);
        System.arraycopy(inorder, 0, in_left, 0, rootIndex);
        System.arraycopy(inorder,rootIndex+1, in_right, 0, inorder.length - rootIndex - 1);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre_left, in_left);
        root.right = buildTree(pre_right,in_right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
