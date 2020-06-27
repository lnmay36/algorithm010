//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] book = new int[nums.length];
        dfs(res, new ArrayList<>(), nums, book);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums , int[] book) {
        if (temp.size()==nums.length) {
            List<Integer> nt = new ArrayList<Integer>(temp);
            res.add(nt);
            return;
        }
        for (int i=0;i<nums.length;++i) {
            if(book[i]==0) {
                book[i] = 1;
                temp.add(nums[i]);
                dfs(res, temp, nums, book);
                temp.remove(Integer.valueOf(nums[i]));
                book[i] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
