//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        // 更新左边柱子的最高高度
        int[] max_left = new int[height.length];
        int max_l = -1;
        for (int i=0;i<max_left.length;++i) {
            if (height[i] > max_l) {
                max_l = height[i];
            }
            max_left[i] = max_l;
        }
        // 更新右边柱子的最高高度
        int[] max_right = new int[height.length];
        int max_r = -1;
        for (int i=max_right.length-1;i>=0;--i) {
            if (height[i] > max_r) {
                max_r = height[i];
            }
            max_right[i] = max_r;
        }
        int res = 0;
        //更新雨水量
        for (int i=0;i<height.length;++i) {
            res += Math.min(max_left[i], max_right[i]) - height[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
