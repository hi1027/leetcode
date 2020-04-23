import sun.security.krb5.internal.crypto.dk.ArcFourCrypto;

import java.util.Arrays;
import java.util.TooManyListenersException;

/**
 * @author: zhangsen
 * @date: 2020/4/20 下午10:38
 * @version: 1.0
 * @description: 时间复杂度                   空间复杂度           是否稳定(比如一个序列是 3  4  3  2 ) 一个稳定排序后，前面的3 应该继续保持在后面的3前面
 * 最好    最坏   平均
 * 冒泡排序          O(n)   O(n²)  O(n²)             O(1)                是，因为会逐个比较
 * 选择排序         O(n²)  O(n²)  O(n²)              O(1)                不是，因为选择排序是每次从后面取一个最值，比如上面的例子，就会先从后面取到3的时候，跟前面的3调序
 * 插入排序         O(n)   O(n²)  O(n²)              O(1)                是，插入排序会跟要插入的数字比较
 * 参考资料   https://www.bigocheatsheet.com/
 */
public class Sorts {
    public static void main(String[] args) {
        int[] arr = {1, 2, 34, 5, 23, 5, 23, 123, 32, 354, 5657, 57, 6, 34524, 35, 7, 6745, 6, 45};


//        bubbleSort(arr);
//        selectionSort(arr);
//        insertSort(arr);
//        mergeSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    /**
     *  快速排序  也是分治思想，找到一个基准节点，基于这个几点分成左右2部分，分别排序，
     *  相比于 归并排序   的好处是空间复杂度是o1，因为他原地排序
     * @param arr
     */
    private static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        quickSortInner(arr,0,arr.length-1);
    }

    private static void quickSortInner(int[] arr, int left, int right) {
        if(left >= right){
            return ;
        }

        int partitionIndex = partition(arr,left,right);
        quickSortInner(arr,left,partitionIndex-1);
        quickSortInner(arr,partitionIndex+1,right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                if(i!=index){
                    swap(arr, i, index);
                }
                //交换了 才增加，这就是哨兵节点
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * 归并排序
     * 就是把一个数组分成2分，每次排序分成2组，分别进行排序，并合并，最后在最终拼成一组
     * 利用递归  不断分层   logN
     *
     * @param arr
     */
    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        sort(arr, 0, length - 1);
    }


    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //left + right 数值溢出
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // i  j 检测遍历指针  k 存放指针
        int i = left;
        int j = mid + 1;
        int k = 0;
        //申请一个临时新数组
        int[] temp = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        if (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        if (j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for (int n = 0; n <= right-left; n++) {
            arr[left+n] = temp[n];
        }
    }


    /**
     * 插入排序
     * 把数组分为2段，第一段是有序，每次排序的时候的是，从第二段获取第一个元素，然后插入到第一段，在插入的时候，做排序处理
     * 于 选择排序不通的是，选择排序是在第二段先去一个小的，在放入第一段，这样就不用排序。但是他的空间复杂度是最好都是n2(n平方)，且他是一个不稳定排序算法，
     * 比如  3 3 4 3 1 这样排序后，后面那个3  就会插入到前面那个3前面。。
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            //记录这个值后，那么这个下标  这个坑就可以用来后面移动的数
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < arr[j]) {
                    // 初始的j = i-1  然后这里 arr[j+1] 其实就是刚刚的arr[i] 这样就实现了位置的后移
                    arr[j + 1] = arr[j];
                } else {
                    //j是倒序 如果这里当前取出来的数，比我们J大，那么他就应该不动，
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * 选择排序
     * 把数组分成2段，可以默认第一段是已经排序好的了的数组，第二段是待排序的，
     * 每次从第二段取一个最小的元素放入第一段，因为第一段已经有序，所以只需要拼接几个
     * <p>
     * 选择排序跟插入排序的区别就在
     * 选择排序 第一段是有序的，且每次从第二段取最小，来保证插入第一段的时候，只需要放在后面即可
     * 插入排序 第一段也是有序的，但是他的有序不能保证跟后面的无序段的之间的有序关系，也就是说，插入排序
     * 从第二段无序段取出来的元素，当放入第一段的时候，他要进行逐个比较，才知道放在哪里。
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int tempIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] > arr[tempIndex]) {
                    tempIndex = j;
                }
            }
            int temp = arr[tempIndex];
            arr[tempIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 冒牌排序
     * 其实就是相邻之前的比较
     * 外层循环 记录排了几次，也就是说排了几个数，那么在内存循环的时候，他的最后一位就是外层循环-1
     * 比如 外层循环 i=5 就说明已数组最后5个数已经排序好了，不用再排序了，那么内层循环就要少循环5次，即j< length-i-1;
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        //是否有数据交换
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                    flag = true;
                }
            }
            //这层循环没有数据交换说明已经 排序了 不用再排了
            if (!flag) {
                break;
            }
        }
    }


}
