//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int [] book = new int[nums.length];
        dfs(res, new ArrayList<Integer>(), new HashSet<String>(), book, nums,0);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> t, Set<String> set, int[] book, int[] nums,int step) {
        if (t.size()==nums.length) {
            List<Integer> nt = new ArrayList<>(t);
            StringBuffer sb = new StringBuffer();
            for (int i:nt) {
                sb.append(i);
            }
            String s = sb.toString();
            if(!set.contains(s)) {//用set对走过的路径去重
                set.add(s);
                res.add(nt);
            }
            return;
        }
        for (int i=0;i<nums.length;++i) {
            if(book[i]==0) {
                book[i] = 1;
                t.add(nums[i]);
                dfs(res, t, set, book, nums,step+1);
                t.remove(step);//不能去掉数字，因为原数组可能有重复的数字
                book[i] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
