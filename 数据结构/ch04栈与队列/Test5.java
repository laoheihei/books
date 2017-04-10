//8�ʺ�
class Queen {   
    int x;
    int y;    
    public Queen(int x, int y) { this.x = x; this.y = y; }  
    //������Ҫ�޳�������д����ʱ���������Ͳ����б�һ��Ҫ��ͬ��������ʱ�������Queen.....
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
        //qΪ��ǰҪ�ڷŵĻʺ󣻽��ޣ�0 <= q.y < N.
        Queen q = new Queen(0, 0);               
        Queen temp = q;
        while (true) {
            //��qδ����ʱ�������еĻʺ�ȶ��ҵ��ɰڷŵ�ǰ�ʺ����.
            while ( ( q.y < N ) && solution.find(q) )
                q.y++;
            //�����ڿɰڷŵ���.
            if (q.y < N) {                
                solution.push(q);                
                //�����ҵ�ȫ��N���ʺ�����ѭ��.
                if ( N <= solution.size() )
                    break;
                //ת����һ�У���0��ʼ��̽��һ�ʺ�.
                q = new Queen(temp.x + 1, 0);
                temp = q;
            }
            //�����ڿɰڷŵ��У���ʱq�Ѿ�����.
            else {
                //����һ�У���̽��һ��.
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