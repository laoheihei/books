//ŷ������㷨: շת���
//����������m��n�����Լ��
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