//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组 
// 👍 530 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals==null)
            return new int[1][2];
        if (intervals.length==0)
            return new int[][] {};
        Arrays.sort(intervals,(o1,o2)->(o1[0]-o2[0]));//按区间的左端点排序

        int[][] res = new int[intervals.length][2];
        int idx = 0;
        int[] begin = intervals[0];
        res[idx++] = begin;//将第一个区间加入 merged 数组中
        for (int i = 1;i < intervals.length;++i) {
            if (intervals[i][0] > begin[1]) {//如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾
                res[idx++] = intervals[i];
                begin = intervals[i];
            }
            else
                begin[1] = Math.max(begin[1], intervals[i][1]); //否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值
        }

        return Arrays.copyOf(res, idx);//返回结果数组的一部分
    }
}
//leetcode submit region end(Prohibit modification and deletion)
