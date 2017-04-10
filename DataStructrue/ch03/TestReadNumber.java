//字符串转数字
//考虑：+2343、-34242
//考虑非数字情况：用isDigit()做判断
public class TestReadNumber {
    public static float readNumber(String str) throws Exception {
        char[] arrS = str.toCharArray();
        Stack<Float> s = new Stack<>();
        boolean isDecimal = false;     //是否是小数
        float count = 1;               //小数位的权值
        int signBit = 1;               //符号位
        int digit = 0;                 //每一位的数字
        for (int i = 0; i < arrS.length; i++) {
            if (i == 0) {
                if (arrS[i] == '-') { signBit = -1; continue; }
                if (arrS[i] == '+') { signBit = 1; continue; }
            }
            
            if (arrS[i] == '.') {
                isDecimal = true;
                continue;
            }
            
            if (isDigit(arrS[i])) {
                digit = arrS[i] - '0';
                if (isDecimal) {
                    count /= 10;
                    s.push(s.pop() + digit * count);
                    continue;
                } else {
                    if (s.isEmpty())
                        s.push((float)digit);
                    else 
                        s.push(s.pop() * 10 + digit);
                }
            }
            
            else
                throw new Exception("不是数字");
                   
        }
        return signBit * s.pop();
    }
    public static boolean isDigit(char s) {
        return '0' <= s && s <= '9';
    }
    public static void main(String[] args) throws Exception {
        System.out.println(readNumber("+0.123456"));
        System.out.println(readNumber("-120.1234"));
        System.out.println(readNumber("-67435"));
        System.out.println(readNumber("34467435"));
        System.out.println(readNumber("grft"));
        System.out.println(readNumber("1234gr"));
    }
    
    
}