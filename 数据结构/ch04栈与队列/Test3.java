/*
* �ж�ջ��ϴ: �ж�output�Ƿ���input��ջ��ϴ.
* input[] = {ջ����ջ��}��output[] = {ջ�ף�ջ��}��
* input��ջ����ʾ���ȴ�input���븨��ջ��Ԫ�أ�
* output��ջ�ױ�ʾ���ȴӸ���ջ��ջ��Ԫ��.
* ˼·��ģ��input��output�Ĺ��̣��ɹ�����true��ʧ�ܷ���false.
* �ܽ᣺input = {i, j, k}�����Ľ���Ϊoutput = {k, i, j}. ��: ��kΪ���ȳ�ջ��Ԫ�أ���ô��ջ��˳���Ϊ k -> j -> i
*/
public class Test3 {
    static Integer[] input = {1, 2, 3};
    public static boolean isStackPermutation(Integer[] output) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0, j = 0; i < input.length; i++) {
            /*
            * NOTICE! 
            * ���������Integer�����ԭ��
            * s.peek()����Integer��Integer�ں�int���Ͳ�������ʱ���Զ�����Ϊint.
            * ��s.peek()���ܷ���null��null���Ͳ��ܸ���������������.
            * ��null�Զ������throws NullPointerException().
            */
            while (output[i] != s.peek()) {
                if (input.length <= j) return false;
                s.push(input[j++]);
            }
            s.pop();
        }
        
        return s.isEmpty();
    }
    
    public static void main(String[] args) {
        Integer[] o1 = {3, 2, 1};
        Integer[] o2 = {3, 1, 2};
        System.out.println(isStackPermutation(o1));
        System.out.println(isStackPermutation(o2));
    }
}