//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        if(root==null)
            return res;
        while (!q.isEmpty()) {
            Node cur = q.peek();
            List<Integer> level = new ArrayList<>();
            int temp_size = q.size();//这次层节点的数量
            for (int i=0;i<temp_size;++i) {
                cur = q.remove();
                level.add(cur.val);
                for (Node nn:cur.children) {
                    if (nn!=null)
                        q.add(nn);
                }
            }
            if (level.size()>0)
                res.add(level);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
