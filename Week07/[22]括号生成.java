//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1181 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<> ();
        dfs(res, n, "", 0, 0);
        //System.out.println(res.size());
        return res;
    }
    public void dfs(List<String> res, int n, String temp, int left, int right) {
        if (left==n && right==n) {
            res.add(temp);
            return;
        }
        if (left < n)
            dfs(res, n, temp + '(', left+1, right);
        if (left > right)
            dfs(res, n, temp + ')', left, right+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
