//P33: 高效率的幂运算
public class Pow {
    private Pow() {}
    //x^n，且x、n >= 0
    public static long pow(long x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n % 2 == 0)
            return pow(x * x, n / 2);
        else 
            return pow(x * x, n / 2) * x;
    }
    
    public static long pow1(long x, int n) {
        long p = 1;
        while (true) {
            if (n == 0) return 1;
            if (n == 1) break;
            if (n % 2 == 0) {
                x *= x;
                n /= 2;
            }
            else if (n % 2 == 1) {
                p *= x;
                x *= x;
                n /= 2;
            }
        }
        return p * x;
    }
    
    public static void main(String[] args) {
        System.out.println(pow(2, 0) + " " + pow1(2, 0));
        System.out.println(pow(2, 1) + " " + pow1(2, 1));
        System.out.println(pow(2, 2) + " " + pow1(2, 2));
        System.out.println(pow(2, 3) + " " + pow1(2, 3));
        System.out.println(pow(2, 4) + " " + pow1(2, 4));
        System.out.println(pow(2, 10) + " " + pow1(2, 10));
        System.out.println(pow(2, 11) + " " + pow1(2, 11));
        System.out.println(pow(2, 12) + " " + pow1(2, 12));
        System.out.println(pow(2, 13) + " " + pow1(2, 13));
    }
}