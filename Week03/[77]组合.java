//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),n, k, 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> t, int n, int k, int step) {
        if (t.size()==k) {
            List<Integer> nt = new ArrayList<>(t);
            res.add(nt);
            return;
        }
        for (int i=step;i<n;++i) {
            t.add(i+1);
            dfs(res,t,n,k,i+1);
            t.remove(Integer.valueOf(i+1));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
