//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m+n-1;//数组nums1的空位置

        int a=m-1,b=n-1;//从后往前合并
        while(a>=0&&b>=0) {
            nums1[idx--] = nums1[a] > nums2[b] ? nums1[a--] : nums2[b--];
        }
        System.arraycopy(nums2,0,nums1,0,b+1);//拷贝b剩余的元素，注意长度
    }
}
//leetcode submit region end(Prohibit modification and deletion)
