/*
* 判断栈混洗: 判断output是否是input的栈混洗.
* input[] = {栈顶，栈底}；output[] = {栈底，栈顶}；
* input的栈顶表示最先从input进入辅助栈的元素；
* output的栈底表示最先从辅助栈出栈的元素.
* 思路：模拟input到output的过程，成功返回true，失败返回false.
* 总结：input = {i, j, k}，它的禁形为output = {k, i, j}. 即: 若k为最先出栈的元素，那么出栈的顺序必为 k -> j -> i
*/
public class Test3 {
    static Integer[] input = {1, 2, 3};
    public static boolean isStackPermutation(Integer[] output) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0, j = 0; i < input.length; i++) {
            /*
            * NOTICE! 
            * 这里就是用Integer数组的原因：
            * s.peek()返回Integer，Integer在和int类型参与运算时会自动拆箱为int.
            * 但s.peek()可能返回null，null类型不能赋给基本数据类型.
            * 将null自动拆箱会throws NullPointerException().
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