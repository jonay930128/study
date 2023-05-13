package leetcode.sort;

/**
 * @author ruxing.wrx
 * @date 2023/4/25 14:34
 */
public class 排序 {
    public static void main(String[] args) {
        int arr[] = {5,2,7,8,4,1,9};
//        冒泡(arr);
        选择(arr);
        System.out.println(arr);
    }


    private static void 冒泡(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前一个数字大就交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void 选择(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                // 如果前一个数字大就交换
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
