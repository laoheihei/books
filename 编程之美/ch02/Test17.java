//数组循环右移k位
public class Test17 {
    public static void rightCyclicShift(int[] a, int k) {
        k = k % a.length;
        reverse(a, a.length - k, a.length - 1);
        reverse(a, 0, a.length - k - 1);
        reverse(a, 0, a.length - 1);
    }
    public static void reverse(int[] a, int lo, int hi) {
        while (lo < hi)
            swap(a, lo++, hi--);
    }
    public static void swap(int[] a, int lo, int hi) {
        int temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rightCyclicShift(a, 3);
        for (int num : a)
            System.out.print(num + " ");
    }
}