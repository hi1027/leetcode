public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 8, 9, 11, 333, 1134, 93434};
//        int index = loop(arr, 9);
        int index = loop(arr, 9);
        System.out.println(recursion(arr, 8, 0, arr.length - 1));
    }

    /**
     * 递归
     *
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int recursion(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return recursion(arr, target, left, mid - 1);
        } else {
            return recursion(arr, target, mid + 1, right);
        }
    }

    /**
     * 循环
     *
     * @param arr
     * @param target
     * @return
     */
    private static int loop(int[] arr, int target) {
        int left = 0;
        //这一步比较重要，定义方式直接决定了你的while条件和mid的 递减 条件
        //这里其实这样定义 就说了整个区间是一个闭区间[left,right]
        int right = arr.length - 1;
        //因为是闭区间 所以这里要 <=
        while (left <= right) {
            //这里不用left+right是因为 可能出先越界的可能
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            //这里的减1  和  加1   也是因为上面我们取的是闭区间
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}
