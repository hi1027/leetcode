package sort;

import java.util.Arrays;

public class Sorts1 {
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
     * 快速排序  类似归并排序 不同于归并排序
     * 归并排序是每次递归排序后，要用临时空间来 归并2个数组
     * 快速排序是，在已基准节点的时候，就已经分开了，是在原地进行值的互换，不需要新的空间
     *
     * @param arr
     */
    private static void quickSort(int[] arr) {
        int right = arr.length;
        quickSort(arr, 0, right - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex-1);
        quickSort(arr, partitionIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left;
        //哨兵节点 也是循环的起始节点
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                if(i!=index){
                    sawp(arr,i,index);
                }
                index++;
            }
        }
        //这一步是为了，把基准节点放到中间去
        sawp(arr,pivot,index - 1);
        return index - 1;
    }

    private static void sawp(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 归并排序，就是先把数组分成2部分(每个子部分也都递归分割)，各自排序，在合并
     *
     * @param arr
     */
    private static void mergeSort(int[] arr) {
        int right = arr.length;
        mergeSort(arr, 0, right - 1);
    }

    /**
     * 归并排序     时间复杂度很稳定 logN但是他的空间复杂度是O(n)，所以他适合数据量小的排序
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        //合并2个数组，先申请一个刚好可以放下2个数组之和大小的数组
        //因为用到了临时数组，这就是归并排序的弊端，空间复杂度高了O(n)，但他的时间复杂度很稳定，都是logN
        int[] temp = new int[right - left + 1];
        //我们是要合并2个数组，就是要把2个数组中的元素逐一比较
        // 1-3-5   2-4-6  先用1和2比，然后再移动1的指针到3，再比较3和2，然后移动2的指针的，然后再比较3和4  以此内推，就能判断出我们要定义的变量
        //定义游标，用于循环
        int i = left;
        int j = mid + 1;
        // 用于存放排好序数的下标
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                //先赋值，然后各自再递增
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //有可能 2个数组不一样长，所以这里可能还有不是空的 ，要继续排序
        if (i <= mid) {
            temp[k++] = arr[i++];
        }

        if (j <= right) {
            temp[k++] = arr[j++];
        }
        //把临时数组的数据 copy到原数组，临时数组0-n,原数组 left-right
        for (int n = 0; n <= right - left; n++) {
            arr[left + n] = temp[n];
        }
    }


    /**
     * 插入排序
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        int length = arr.length;
        //外层循环获取要排序的元素，从第一个开始遍历，默认第一个已经排序好
        for (int i = 1; i < length; i++) {
            int temp = arr[i];
            //再跟已经排序好的元素比较，找到一个位置放进去，从又到左逐一比较
            //因为要排第i个数，说明前面已经排序的就是i-1个元素
            int j = i;
            //如果要排序的元素，比j-1还要小，那说明当前的j要往后移动
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    /**
     * 分成2快，每次从第二块，取一个最小值，放入第一块，因为第一块的前面已经有序，所有只需要跟当前循环的元素交换即可
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        int length = arr.length;
        //外层循环记录排到第几个数了
        for (int i = 0; i < length; i++) {
            //初始化最小值，因为前面i个元素已经比较过了，所以这里最小值肯定在后面
            int tempIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[tempIndex] > arr[j]) {
                    tempIndex = j;
                }
            }
            //把后面的最小值跟当前的I交换，其实这里也可以稍微优化下，就是比较下，再判断是否要交换，但是大部分场景是需要交换的，所以这里就不比较了
            int temp = arr[i];
            arr[i] = arr[tempIndex];
            arr[tempIndex] = temp;
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        int length = arr.length;
        //优化点
        boolean isSwap = false;
        //外层循环并不是用来比较的，而是用来计数，已经排好几个数了，因为每次冒泡都会怕排好一个数
        for (int i = 0; i < length; i++) {
            //内层循环就是比较了，j<length - 1- i; 因为已经拍了i个数了，所以这里要减去
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j + 1] ^ arr[j];
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                    arr[j] = arr[j + 1] ^ arr[j];
                    isSwap = true;
                } else {
                    isSwap = false;
                }
            }
            if (!isSwap) {
                return;
            }
        }
    }
}
