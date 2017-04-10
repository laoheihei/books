//8皇后
class Queen {   
    int x;
    int y;    
    public Queen(int x, int y) { this.x = x; this.y = y; }  
    //这里我要哭出来：重写方法时，方法名和参数列表一定要相同。我在做时传入的是Queen.....
    public boolean equals(Object compare) {
        Queen q = (Queen)compare;
        return (y == q.y)
               || (q.x - x == q.y - y)
               || (q.x - x == y - q.y);
    }
    public String toString() {
        return Integer.toBinaryString((int)Math.pow(2, y));
    }
}
public class Test5 {
    public static void placeQueens(int N) {        
        Stack<Queen> solution = new Stack<>();
        //q为当前要摆放的皇后；界限：0 <= q.y < N.
        Queen q = new Queen(0, 0);               
        Queen temp = q;
        while (true) {
            //当q未出界时，与已有的皇后比对找到可摆放当前皇后的列.
            while ( ( q.y < N ) && solution.find(q) )
                q.y++;
            //当存在可摆放的列.
            if (q.y < N) {                
                solution.push(q);                
                //当已找到全部N个皇后，跳出循环.
                if ( N <= solution.size() )
                    break;
                //转入下一行，从0开始试探下一皇后.
                q = new Queen(temp.x + 1, 0);
                temp = q;
            }
            //不存在可摆放的列，此时q已经出界.
            else {
                //回溯一行，试探下一列.
                q = solution.pop();                
                q.y++;
                temp = q;
            }
        }
        int length = solution.size();
        for (int i = 0; i < length; i++)
            System.out.printf("%8s\n", solution.pop());                    
    }
    public static void main(String[] args) {
        placeQueens(8);
    }
    
    
}