/**
 * @author:ln
 * 堆排序
 */
package heap;

import java.util.Random;

public class heapsort {

    public heapsort(int[] a) {

        // 建立大顶堆
        for (int i=a.length/2-1;i>=0;--i) {
            heapifyDown(a, i,a.length);
        }
    }

    public void sort(int []a){
        int n = a.length;
        while (n>0) {
            int t = a[n-1];
            a[n-1] = a[0];
            a[0] = t;
            heapifyDown(a, 0, --n);
        }
    }

    public void show(int[] heap) {
        for (int i:heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void heapifyDown(int[] a,int i, int size) {

        while (i*2+2<=size-1 || i*2+1<=size-1) {
            int left = 2*i+1,right=left+1,maxChild=left;
            if (left<size)
                maxChild = left;
            if (right<size && a[right] > a[left])
                maxChild = right;
            if (a[i] < a[maxChild]) {
                int t = a[i];
                a[i] = a[maxChild];
                a[maxChild] = t;
                i = maxChild;
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {

        //int[] arr = {12, 11, 13, 5, 6, 7};
        Random r = new Random(1);
        int[] arr = new int[20];
        for (int i=0;i<arr.length;++i) {
            arr[i] = r.nextInt(100);
        }
        System.out.println("原数组：");
        for (int i:arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        heapsort h = new heapsort(arr);
        System.out.println("大顶堆：");
        h.show(arr);
        h.sort(arr);
        System.out.println("排序结果：");
        h.show(arr);
    }
}
