//进制转换
public class Test2 {
    //十进制数n到base进制的转换
    static char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',};
    public static String convert(int n, int base) {
        String ret = "";
        while (0 < n) {
            ret += digit[n % base];
            n /= base;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        System.out.println(convert(5, 2));
    }
}