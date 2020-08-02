//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 223 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0)
            return false;
        while (n>2) {
            if ((n&1)==1)//判断奇数，比%运算快
                return false;
            n = n >> 1;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
