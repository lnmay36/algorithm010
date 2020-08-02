//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 70 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int begin = 0;
        //将arr2里的每个元素作为pivot，对原数组使用分治法排序
        for (int pivot:arr2) {
            begin = partition(arr1, begin, pivot);
        }
        // 对arr1后半部分升序
        // System.out.println(begin);
        int[] temp = Arrays.copyOfRange(arr1, begin, arr1.length);//from to都是下标
        Arrays.sort(temp);
        System.arraycopy(temp, 0, arr1, begin, arr1.length-begin);
        return arr1;
    }
    public int partition(int[] arr, int begin, int pivot) {
        int counter = begin;
        for (int i=begin;i<arr.length;++i) {
            if (arr[i]==pivot) {
                int t = arr[i];arr[i] = arr[counter];arr[counter] = t;
                counter++;
            }
        }
        return counter;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
