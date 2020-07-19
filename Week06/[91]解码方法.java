//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 440 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
//        dp[i]表示str[0...i]的译码方式总数
//        1、若s[i]=='0'：
//        若s[i-1]=='1' or '2', dp[i] = dp[i-2]
//        str[0...i]被唯一译码为str[0...i-2] + 'T'，
//        译码方式总数不增加；
//        否则， dp[i] = 0，因为'30' '40'...无法被译码
//        2、若s[i-1]=='1':
//        dp[i] = dp[i-1] + dp[i-2]
//        s[i-1]和s[i]分开译码，是dp[i-1] str[0...i-2]'A' + '2'
//        s[i-1]和s[i]合并译码，是dp[i-2] str[0...i-2] + '12'
//        3、若s[i-1]=='2' and s[i]=='1'~'6':
//        dp[i] = dp[i-1] + dp[i-2]
//        同2
//        4、其他
//        dp[i] = dp[i-1]
        int[] dp = new int[s.length()];
        if (s.charAt(0)=='0')
            return 0;
        if (s.charAt(0)!='0')
            dp[0] = 1;
        if (s.length()>1) {
            if (s.charAt(1)=='0') {
                if (s.charAt(0)=='1'||s.charAt(0)=='2') {
                    dp[1] = 1;
                }else
                    dp[1] = 0;
            }
            else {
                if (s.charAt(0) == '2' && s.charAt(1) <= '6' && s.charAt(1) >= '1')
                    dp[1] = 2;
                else if (s.charAt(0) == '1')
                    dp[1] = 2;
                else
                    dp[1] = 1;
            }
        }
        for(int i=2;i<s.length();++i) {
            if (s.charAt(i)=='0') {
                if (s.charAt(i-1)=='1'||s.charAt(i-1)=='2') {
                    dp[i] = dp[i-2];
                }else
                    dp[i] = 0;
            }
            else {
                if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6' && s.charAt(i) >= '1')
                    dp[i] = dp[i - 1] + dp[i - 2];
                else if (s.charAt(i - 1) == '1')
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
