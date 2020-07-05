//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        int left = 0,right = matrix[0].length-1;
        if(right<0)
            return false;
        for (int i=0;i<matrix.length;++i) {
            if (matrix[i][0] <= target) {//将每一行第一个元素小于target的一维数组都二分查找一遍
                left = 0;
                right = matrix[0].length-1;
                while (left <= right) {
                    int mid = left+(right-left)/2;
                    //System.out.println(left+","+right+","+mid);
                    if (matrix[i][mid]==target)
                        return true;
                    else if(matrix[i][mid]<target)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
