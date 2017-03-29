//欧几里得算法: 辗转相除
//返回两个数m、n的最大公约数
public class GCD {
    
    private GCD() {}
    
    public static int gcd(int m, int n) {
        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
    
    public static void main(String[] args) {
        System.out.println(gcd(8, 12));
    }
}