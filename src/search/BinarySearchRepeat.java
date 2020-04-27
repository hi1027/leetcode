package search;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class BinarySearchRepeat {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //有多个九，查找第一个 和 最后一个
        int[] arr = {1, 3, 6, 8, 9, 9, 9, 9, 11, 333, 1134, 93434};
//        int first = findFirst(arr, 9);
//        int last = findLast(arr, 9);
//        System.out.println(first + "--------" + last);

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> findFirst(arr, 9));
        CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> findLast(arr, 9));

        System.out.println(integerCompletableFuture.get());
        System.out.println(integerCompletableFuture1.get());


    }

    /**
     * 查早第一个目标元素
     *
     * @param arr
     * @param target
     * @return
     */
    private static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                //如果等于，则要考虑是否是第一个，需要进行再次判断
                //如果当前下标已经是0，则肯定是第一个，如不不是0，而且他前面的数字不等于要查找的数字，那么他肯定是第一个
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                } else {
                    //如果他前面的数字也等于目标数字，则再次查询，缩小right
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查早最后一个目标元素
     *
     * @param arr
     * @param target
     * @return
     */
    private static int findLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                //如果等于，则要考虑是否是第一个，需要进行再次判断
                //如果当前下标已经最后一个元素，则肯定是最后一个，如不是，就跟后面的比
                if (mid == right || arr[mid + 1] != target) {
                    return mid;
                } else {
                    //如果他前面的数字也等于目标数字，则再次查询，缩小right
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
