//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划


import java.util.HashSet;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        // 丑数的2、3、5倍还是丑数
        long res = (long) 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();//存储结果
        pq.offer(res);
        for (int i=0;i<n;++i) {
            res = pq.remove();
            long a2 = res * 2;
            long a3 = res * 3;
            long a5 = res * 5;
            if (!pq.contains(a2))
                pq.offer(a2);
            if (!pq.contains(a3))
                pq.offer(a3);
            if (!pq.contains(a5))
                pq.offer(a5);
        }
        return (int)res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
