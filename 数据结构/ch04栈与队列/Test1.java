//HTML标志匹配 + 括号匹配检测
public class Test1 {   
    public static boolean testTag(char[] arrS) {
        Stack<String> stack = new Stack<>();  //存入字符串XXX；其中XXX为"<XXX>"中出现的字符串.
        Stack<Character> s = new Stack<>();   //存入相应的左括号：'('、'['、'<'、'{'.    
        String current = null;                //表示XXX；其中XXX为"<XXX>"或"</XXX>"中出现的字符串.
        
        for (int i = 0; i < arrS.length; i++)
            switch (arrS[i]) {
                case '(': case '{': case '[': s.push(arrS[i]); break;
                case ')': if (s.isEmpty() || s.pop() != '(') return false; break;
                case '}': if (s.isEmpty() || s.pop() != '{') return false; break;
                case ']': if (s.isEmpty() || s.pop() != '[') return false; break;
                case '>': if (s.isEmpty() || s.pop() != '<') return false; break;
                case '<':
                    s.push(arrS[i]);
                    if (arrS[i + 1] != '/') {
                        current = readTag(arrS, i);
                        stack.push(current);                        
                    } else {
                        current = readTag(arrS, i + 1);                        
                        if (stack.isEmpty() || !current.equals(stack.pop())) {                            
                            return false;
                        }
                    }
                    break;                    
                default: break;                 
            }
            
        return stack.isEmpty() && s.isEmpty();
    }
    //返回arrS[index]到'>'之间的字符串
    public static String readTag(char[] arrS, int index) {        
        StringBuilder sb = new StringBuilder();
        for (index += 1; arrS[index] != '>'; index++)
            sb.append(arrS[index]);
        String ret = new String(sb);
        return ret;
    }
    
    public static void main(String[] args) {
        String s = "(er){fds[dfg]vd(s)vdvd}gdsgsgsdg<abc>()<dfs></dfs></abc>";
        System.out.println(testTag(s.toCharArray()));
    }
}
    