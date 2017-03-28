//P26最大子序列和问题
public class MaxSubSum {
    private MaxSubSum() {}
    
    public static maxSubSum1(int[] a) {
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
}