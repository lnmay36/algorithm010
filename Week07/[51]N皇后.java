//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 471 👎 0


import java.util.ArrayList;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<Integer> queens = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        dfs(n, 0, new int[n]);
        return res;
    }
    public void dfs(int n, int step, int[] queen) {
        if (step>=n) {
            List<String> temp = new ArrayList<>();
            for (int i:queen) {
                String s = "";
                int j=0;
                for (;j<i;++j)
                    s += ".";
                s+="Q";
                for (j=i+1;j<n;++j)
                    s += ".";
                temp.add(s);
            }
            res.add(temp);
        }
        for (int i=0;i<n;++i) {
            if (!queens.contains(i) && !pie.contains(step-i) && !na.contains(step+i)) {
                queens.add(i);//行
                pie.add(step-i);//撇
                na.add(step+i);//捺
                queen[step] = i;//列
                dfs(n, step+1, queen);
                queens.remove(i);
                pie.remove(step-i);
                na.remove(step+i);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
