//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划 
// 👍 282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    dp[i][j]代表下标为i，j的字符串s[i...j]是否是回文串，1表示回文串的个数
//    若s[i]==s[j]:
//        dp[i][j] = dp[i+1][j-1] + 1
//    否则
//        dp[i][j] = 0
    public int countSubstrings(String s) {
        int m = s.length();
        int count = 0;
        int[][] dp = new int[m][m];
        for (int i=0;i<m;++i)
            dp[i][i] = 1;//每一个单独的字符都是回文串
        for (int i=m-2;i>=0;--i) {//从倒数第二个字符开始判断
            for (int j=i+1;j<m;++j) {//依次判断其右边的字符
                if (s.charAt(i)==s.charAt(j)) {
                    if (j-i==1)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j]>0)
                    count++;
            }
        }
        // for (int i=0;i<m;++i) {//从倒数第二个字符开始判断
        //     for (int j=0;j<m;++j) {
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }
        return m + count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
