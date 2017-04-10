//�ַ���ת����
//���ǣ�+2343��-34242
//���Ƿ������������isDigit()���ж�
public class TestReadNumber {
    public static float readNumber(String str) throws Exception {
        char[] arrS = str.toCharArray();
        Stack<Float> s = new Stack<>();
        boolean isDecimal = false;     //�Ƿ���С��
        float count = 1;               //С��λ��Ȩֵ
        int signBit = 1;               //����λ
        int digit = 0;                 //ÿһλ������
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
                throw new Exception("��������");
                   
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