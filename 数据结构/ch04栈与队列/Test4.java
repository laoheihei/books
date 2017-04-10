/*
* ��StringתΪfloat   
*/
public class Test4 {
    public static float convertDigit(String s) throws Exception {
        char[] arrS = s.toCharArray();
        Stack<Float> stack = new Stack<>();
        
        boolean isDecimal = false;       //arrS[i]Ϊ��������orС������
        int signBit = 1;                 //����λ����or��
        float value = 1;                   //С�����ֵ�λֵ��10^(-n); NOTICE: valueһ��ҪΪfloat, ֮ǰ�����д��int������С������һֱΪ0.
        float current = 0;               //arrS[i]����ֵ
        
        //����arrS[0]
        switch(arrS[0]) {
            case '+': break;
            case '-': signBit = -1; break;
            case '0': 
                if (arrS[1] != '.') throw new Exception("���ǺϷ�����"); 
            case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                stack.push((float)(arrS[0] - '0'));
                break;
            default: throw new Exception("���ǺϷ�����");
            
        }
           
        for (int i = 1; i < arrS.length; i++) {                        
            if (arrS[i] == '.') 
                isDecimal = true;
            else if (isDigit(arrS[i])) {
                current = arrS[i] - '0';
                if (!isDecimal) {
                    //���úÿ�һ�£�Ҫ�ж�stack�Ƿ�Ϊ�գ��������ArrayIndexOutOfBoundsException.
                    stack.push(stack.isEmpty() ? current 
                                    : stack.pop() * 10 + current);                
                } else {
                    value /= 10;
                    stack.push(stack.pop() + current * value);
                }
            } else            
                throw new Exception("���ǺϷ�����");           
        }
        
        return signBit * stack.pop();                
    }
    public static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "+0.4131",
               s2 = "-3424.144",
               s3 = "0.54543",
               s4 = "a43242",               
               s5 = "432a.54d3";
        System.out.println(convertDigit(s1));
        System.out.println(convertDigit(s2));
        System.out.println(convertDigit(s3));
        System.out.println(convertDigit(s5));
    }
}