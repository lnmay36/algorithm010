//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int bit = 1;//进位
        for (int i=digits.length-1;i>=0;--i) {
            digits[i] += bit;

            if (digits[i]>=10) {
                digits[i] -= 10;
                bit = 1;
            } else
                bit = 0;
        }
        if (bit==1){
            int [] res = new int[digits.length+1];
            for (int i=1;i<res.length;++i)
                res[i] = digits[i-1];
            res[0]=1;
            return res;
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
