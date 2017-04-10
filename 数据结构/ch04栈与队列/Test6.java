//中缀表达式求值
public class Test6 {
    
    //支持的九种运算符
    static char[] operation = {'+',    '-',    '*',    '/',    '^',    '!',    '(',    ')',    '\0'};
    
    //pri[][]: 栈顶运算符与当前运算符的优先级比较. ' '表示语法错误; '>'表示栈顶运算符优先级大于当前运算符，说明可以进行相应的计算.
    static char[][] pri = {
        /*             |------------当前运算符-----------------|     */
        /*             +    -    *    /    ^    !    (    )    \0    */ 
        /* --  + */  {'>', '>', '<', '<', '<', '<', '<', '>', '>'},
        /* |   - */  {'>', '>', '<', '<', '<', '<', '<', '>', '>'},
        /* 栈  * */  {'>', '>', '>', '>', '<', '<', '<', '>', '>'},
        /* 顶  / */  {'>', '>', '>', '>', '<', '<', '<', '>', '>'},
        /* 运  ^ */  {'>', '>', '>', '>', '>', '<', '<', '>', '>'},
        /* 算  ! */  {'>', '>', '>', '>', '>', '>', ' ', '>', '>'},
        /* 符  ( */  {'<', '<', '<', '<', '<', '<', '<', '=', ' '},
        /* |   ) */  {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        /* -- \0 */  {'<', '<', '<', '<', '<', '<', '<', ' ', '='}
    };
    
    //比较栈顶运算符与当前运算符的优先级.
    public static char orderBetween(char stackTop, char current) {
        //System.out.println("top, cur: " + stackTop + ", " + current);
        int top = findOptr(stackTop);
        int cur = findOptr(current);
        return pri[top][cur];
    }
    
    //找到传入的运算符c在operation[]中的索引位置.
    public static int findOptr(char c) {
        int i = 0;
        while (i < operation.length && c != operation[i])
            ++i;
        return i;
    }

    //读s[]中以s[idx]开始的数字并存入栈opnd中，输出idx.
    //传入idx时s[idx]为数字，输出idx时s[idx]为非数字.
    public static int readNum(char[] s, int idx, Stack<Float> opnd) {
        float current = 0;
        float value = 1;           //小数部分各位权值：10^(-n)
        boolean isDecimal = false;
        opnd.push((float)(s[idx++] - '0'));
        
        while (idx < s.length) {            
            if (s[idx] == '.') {
                isDecimal = true;
                ++idx;                   
            }
            else if (isDigit(s[idx])) {
                current = s[idx] - '0';
                if (!isDecimal) {
                    opnd.push(opnd.pop() * 10 + current);
                    ++idx;
                }
                else {
                    value /= 10;
                    opnd.push(opnd.pop() + current * value);
                    ++idx;
                }
            }
            else
                break;           
        }
        //System.out.println(opnd.peek());
        return idx;
    }
    
    public static boolean isDigit(char s) {
        return '0' <= s && s <= '9';
    }
           
    //对表达式str求值，//并转换为逆波兰表达式RPN.
    public static float evaluate(String str/*, String[] RPN*/) throws Exception {
        str += '\0';       //判断当前算术表达式结束的标志
        char[] s = str.toCharArray();
        Stack<Float> opnd = new Stack<>(); Stack<Character> optr = new Stack<>();
        optr.push('\0');   //哨兵节点
        int i = 0;         //s的索引
        while (!optr.isEmpty() && i <= s.length) {
            if (isDigit(s[i])) {
                //readNum(char[], int, Stack<Float>)返回值为char[]中int后第一个非数字字符的索引.
                //apend()方法：将当前字符串加入String[] RPN中.
                i = readNum(s, i, opnd); //append(RPN, opnd.peek().toString());
            }
            else
                //比较当前运算符与栈顶运算符.                
                switch (orderBetween(optr.peek(), s[i])) {
                    //若栈顶运算符优先级小于当前运算符，当前操作符入栈.
                    case '<':
                        optr.push(s[i++]);
                        break;
                    //当前运算符为')'或尾部哨兵'\0'，弹出栈顶运算符.
                    case '=':
                        optr.pop(); ++i;
                        break;
                    //'>': 可以进行运算.
                    //NOTICE！ case '>'时没有++i！因为s[i]会一直与栈顶运算符比较.
                    //如果栈顶运算符 '>' s[i]，说明可以进行运算——弹出栈顶运算符与需要的操作数进行运算，然后再将s[i]与栈顶运算符比较...
                    //直到栈顶运算符 '<=' s[i]时，才会++i，与下一个当前运算符s[i]进行优先级比较.
                    case '>':
                        char op = optr.pop(); //append(RPN, op);
                        if ('!' == op) {
                            float pOpnd = opnd.pop();
                            opnd.push(calcu(op, pOpnd));
                        } else {
                            float pOpnd2 = opnd.pop(), pOpnd1 = opnd.pop();
                            opnd.push(calcu(pOpnd1, op, pOpnd2));
                        }
                        break;
                    default:
                        System.out.println("出现错误运算符：" + s[i]);
                        System.out.println("错误运算符索引：" + i);
                        throw new Exception("语法错误");
                }
        }
        return opnd.pop();
    }
    
    public static float calcu(char c, float opnd) throws Exception {
        
        float ret = opnd;
        float temp = opnd;
        
        if (c != '!') {
            System.out.println("期待运算符：'!'，当前运算符为：" + c);
            throw new Exception("运算符错误");
        }
        
        if (temp == 0)
            ret = 1;
        
        while (--temp > 1) {
            ret *= temp;
        }   
        System.out.println("" + opnd + c + " = " + ret);
        return ret;
    }
    
    public static float calcu(float opnd1, char optr, float opnd2) throws Exception {
        float ret;
        switch(optr) {
            case '+': ret = opnd1 + opnd2; break;
            case '-': ret = opnd1 - opnd2; break;
            case '*': ret = opnd1 * opnd2; break;
            case '/': ret = opnd1 / opnd2; break;
            case '^': ret = (float)Math.pow(opnd1, opnd2); break;
            default: 
                System.out.println("出现未知运算符：" + optr);
                throw new Exception("不支持的运算符");              
        } 
        System.out.println("" + opnd1 + optr + opnd2 + " = " + ret); 
        return ret;
    }
    
    public static void main(String[] args) throws Exception {
        String s = "(0!+1)*2^(3!+4)-(5!-67-(8+9))";
        System.out.println(evaluate(s));
    }
}


























