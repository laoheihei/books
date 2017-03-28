//P31二分查找
public class BinarySearch {
    
    private BinarySearch() {}
    //arr为非降序列
    //在[0, arr.length - 1]中寻找x，成功返回x下标，失败返回-1
    public static <Type extends Comparable<? super Type>> 
    int binarySearch(Type[] arr, Type x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mi = (lo + hi) / 2;
            if (arr[mi].compareTo(x) < 0)      lo = mi + 1;
            else if (x.compareTo(arr[mi]) < 0) hi = mi - 1;
            else                             return mi;
        }
        
        return -1;
    }
    
    //在[0, arr.length - 1]中寻找x，返回arr中值不大于x的最右边元素的数组下标
    public static <Type extends Comparable<? super Type>>
    int binarySearch1(Type[] arr, Type x) {
        int lo = 0;
        int hi = arr.length - 1;
        int mi = 0;
        while (lo <= hi) {
            mi = (lo + hi) / 2;
            if (arr[mi].compareTo(x) <= 0)    lo = mi + 1;
            else                            hi = mi - 1;    
        }
        
        return arr[mi].compareTo(x) <= 0 ? mi : mi - 1;
    }
    
    //返回arr中值不小于x的最左边元素
    public static <Type extends Comparable<? super Type>>
    int binarySearch2(Type[] arr, Type x) {
        int lo = 0; 
        int hi = arr.length - 1;
        int mi = 0;
        while (lo <= hi) {
            mi = (lo + hi) / 2;
            if (arr[mi].compareTo(x) >= 0)    hi = mi - 1;
            else                            lo = mi + 1;
        }
        
        return arr[mi].compareTo(x) >= 0 ? mi : mi + 1;
    }
    
    public static void main(String[] args) {
        Integer[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] b = {0, 1, 2, 3, 4, 5, 5, 5, 5, 5, 5};
        Integer[] c = {0, 1, 2, 3, 4, 5, 5, 5, 5, 5};
        Integer[] d = {0, 1, 2, 3, 4, 5, 5, 5, 5};
        Integer[] e = {0, 1, 2, 3, 4, 5, 5, 5};
        Integer[] f = {0, 1, 2, 3, 4, 5, 5};
        Integer[] g = {0, 1, 2, 3, 4, 5};
        Integer[] h = {0, 1, 2, 3, 4};
        System.out.println("5：" + binarySearch2(a, 5));
        System.out.println("11：" + binarySearch2(b, 6));
        System.out.println("10：" + binarySearch2(c, 6));
        System.out.println("9：" + binarySearch2(d, 6));
        System.out.println("8：" + binarySearch2(e, 6));
        System.out.println("7：" + binarySearch2(f, 6));
        System.out.println("6：" + binarySearch2(g, 6));
        System.out.println("5：" + binarySearch2(h, 6));
        
        
        
    }
}






















