# WEEK08笔记

## 位运算

十进制、二进制、左移、右移、或、与、同或、异或、取反

	x ^ 0 = x
	x ^ x = 0
	x ^ 1s = ~x (1s = ~0)
	x ^ (~x) = 1s
	交换两个数 a = a^b; b = a^b; a = a^b;
	a^b^c = a^(b^c) 结合律
	
常用的指定位置的位运算：

将右边n位清零：

	x & (~0 << n)
	
获取x的第n位的值（0或者1）：

	(x >> n)&1
	
获取x的第n位幂值（第n位幂次的值，忽略其他位，即1000...000）：

	x&(1<<n)
	
将第n位置1:

	x|(1<<n)
	
将第n位置0:

	x&(~(1<<n))
	
将x的最高位到第n位置零：

	x&((1<<n)-1)
	
判断奇偶：

	x&1==1 奇数
	x&1==0 偶数（比%快）	
	
除2 >>1

	mid = (left+rigth)/2 -> mid = (left+rigth)>>1

乘2 <<1

清零最低位的1

	x = x&(x-1)
	
得到最低位的1

	x^-x
	
x&~x = 0

python 有用的内置函数

	bin(n).count('1') 先把n转为二进制，再统计1的个数
	
java 有用的内置函数

	Integer.toBinaryString(n) 将n转为二进制字符串
	
## 排序

* 比较类排序：nlogn
* 非比较类排序：不通过比较来决定元素间的相对次序，O(n)，只能用于整型对象

重点掌握nlogn的排序：快速排序，堆排序，归并排序

**选择排序**：选择最小的元素，依次放在a[i]的位置

```
for (int i=0;i<n;++i) {
    int min = i;
    for (int j=i+1;j < n;++j) {
        if (nums[j] < nums[min])
            min = j;
    }
    int t = nums[i];
    nums[i] = nums[min];
    nums[min] = t;
}
```

**插入排序**：保证数组前半部分有序，从后面的数组元素中依次选择元素，往前插入对应的位置，保持数组有序。 **很容易忘记**

```
for (int i=1;i<n;++i) {
    int cur = nums[i];
    int preIndex = i-1;
    while (preIndex >= 0 && nums[preIndex] > cur ) {
        nums[preIndex+1] = nums[preIndex];//将大的数往前挪
        preIndex--;
    }
    // cur放在nums[preIndex+1]
    nums[preIndex+1] = cur;
}
```

**冒泡排序**：两层循环，交换逆序元素。**很容易忘记**

```
for (int i=0;i<n-1;++i) {
    for (int j = 0; j < n-i-1; ++j) {
        if (nums[j] > nums[j + 1]) {//将大的元素下沉到最高位
            int t = nums[j + 1];
            nums[j + 1] = nums[j];
            nums[j] = t;
        }
    }
}
```

**快速排序**，依次取标杆元素pivot，将比pivot小的元素放在pivot左边，大的元素放在pivot右边，然后继续对pivot左右进行快排。**分治思想**

```
/**
 * 快速排序，依次取标杆元素pivot，将比pivot小的元素放在pivot左边，大的元素放在pivot右边，然后继续对pivot左右进行快排。分治思想
 */
public class quickSort {
    public static void quicksort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int pivot = partition(nums, begin, end);
        quicksort(nums, begin, pivot-1);
        quicksort(nums, pivot+1, end);
    }

    private static int partition(int[] nums, int begin, int end) {
        // pivot:标杆位置，一开始在end位置；counter：小于pivot的元素个数。循环中counter就是小于pivot的下标，最后交换pivot和counter即可
        int pivot = end, counter = begin;//注意初始化位置
        for (int i=begin;i < end;++i) {
            if (nums[i] < nums[pivot]) {
                int t = nums[i];nums[i] = nums[counter];nums[counter] = t;
                counter++;
            }
        }
        // 将counter和pivot交换
        int t = nums[pivot];nums[pivot] = nums[counter];nums[counter] = t;
        return counter;
    }
}
```

**归并排序**

* 将长度为n的数组切成2个长度为n/2的子序列
* 对2个子序列分别使用归并排序
* 将两个有序子序列合并

```
public class mergeSort {
    public static void mergesort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;//(left + right) / 2
        mergesort(nums, left, mid);
        mergesort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    // 合并两个有序数组模板
    private static void merge(int[] nums, int left, int mid, int right) {
        //合并两个数组，nums[left...mid] nums[mid...right]
        int[] temp = new int[right-left+1];//用于存放中间结果的数组，长度和nums一致
        int i = left, j = mid+1;//i是第一个有序数组的起点，j是第二个有序数组的起点
        int k = 0;//temp数组的下标

        while (i<=mid && j<=right) {
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];//将数组中的较小者依次放入temp数组
        }
        // 拷贝剩余元素
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, left, right-left+1);//将结果拷贝回原数组
    }
}
```

**堆排序**

堆插入logn，取堆顶元素O(1)

数组元素依次建立小顶堆

依次取堆顶元素并删除

```
public class heapSort {
    // 用系统自带的PriorityQueue建立小顶堆
    public static  void heapsort(int[] a, String method) {
        if ("builtin".equals(method)) {
            Queue<Integer> max_pq = new PriorityQueue<>();

            // 建立小顶堆
            for (int i=0;i<a.length;++i)
                max_pq.offer(a[i]);

            // 依次取出堆顶元素
            for (int i=0;i<a.length;++i)
                a[i] = max_pq.remove();
        }
    }
    // 自己用数组维护堆
    public static void heapsort(int[] a) {
        int length = a.length;
        if (length==0) return;
        // 建立大顶堆 因为最后要将堆顶元素依次放入数组末尾，所以用大顶堆才会得到升序结果
        for (int i=length/2-1;i>=0;--i) {
            heapify(a, i, length);//从第i个位置向下调整
        }
        //依次取堆顶元素移到数组末尾并删除，这样末尾就是最大值
        while (length>0) {
            int t = a[length-1];a[length-1] = a[0];a[0] = t;
            heapify(a, 0, --length);
        }
    }

    private static void heapify(int[] a,int i, int length) {
        int left = 2*i+1, right = 2*i+2;//左右儿子
        int largest = i;//两个儿子的较大者

        if (left < length && a[left] > a[largest]) {
            largest = left;
        }
        if (right < length && a[right] > a[largest]) {
            largest = right;
        }

        if (largest!=i) {
            int t = a[i];a[i] = a[largest];a[largest] = t;//将较大的儿子上移
            heapify(a,largest,length);
        }
    }
}

```




