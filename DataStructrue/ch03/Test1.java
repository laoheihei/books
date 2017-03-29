//给定表P、L，P、L包含以升序排列的整数。
//操作printLots(L, P)打印L中由P所指定的位置上的元素。
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class Test1 {
    private Test1() {}
    
    public static void printLots(List<Integer> L, List<Integer> P){
        Iterator<Integer> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();
        int start = -1;
        int value = 0;
        int[] ret = new int[P.size()];
        
        while (iterP.hasNext()) {
            int pos = iterP.next();
            if (pos < 0 || L.size() <= pos)
                throw new ArrayIndexOutOfBoundsException();
            
            //此处再看一下，自己写成while(start++ < pos)，想想问什么是错的
            while (start < pos) {
                value = iterL.next();
                start++;
            }
            System.out.print(value + " ");                
        }
    }
    
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> p = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        printLots(l, p);
    }
}