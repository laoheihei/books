//P26最大子序列和问题
public class MaxSubSum {
    
    private MaxSubSum() {}
    
    /*-----------------O(n^2)-------------------*/
    public static int maxSubSum1(int[] a) {
        
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (maxSum < sum)
                    maxSum = sum;
            }
        }
        
        return maxSum;
    }
    
    /*-----------------O(NlogN)-------------------*/
    public static int maxSubSum2(int[] a) {
        
        return maxSubSum2(a, 0, a.length - 1);
    }
    //求[lo, hi]的最大子序列
    private static int maxSubSum2(int[] a, int lo, int hi) {
        
        if (hi < lo + 1)
            return (0 < a[lo]) ? a[lo] : 0;
        
        int mi = (lo + hi) / 2;        
        int leftMax = maxSubSum2(a, lo, mi);
        int rightMax = maxSubSum2(a, mi + 1, hi);
        
        int maxLeftBranch = 0,
            sumLeftBranch = 0,
            maxRightBranch = 0,
            sumRightBranch = 0;
            
        for (int i = mi; i >= lo; i--) {
            sumLeftBranch += a[i];
            if (maxLeftBranch < sumLeftBranch)
                maxLeftBranch = sumLeftBranch;
        }
        for (int i = mi + 1; i <= hi; i++) {
            sumRightBranch +=a[i];
            if (maxRightBranch < sumRightBranch)
                maxRightBranch = sumRightBranch;
        }
        
        int branchMax = maxRightBranch + maxLeftBranch;
        
        return max(leftMax, rightMax, branchMax);
    }
    private static int max(int a, int b, int c) {
        int tempMax = 0;
        tempMax = a < b ? b : a;
        tempMax = c < tempMax ? tempMax : c;
        return tempMax;
    }
    
    /*-----------------------O(n)----------------*/
    public static int maxSubSum(int[] a) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (maxSum < sum)
                maxSum = sum;
            if (sum < 0)
                sum = 0;
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] a = {4, -3, 5, -2, -1, 2, 6, -2};
        System.out.println(maxSubSum(a));
        System.out.println(maxSubSum1(a));
        System.out.println(maxSubSum2(a));
    }
}
























