//给定两个已排序的表L1、L2，使用表操作求L1与L2的并集
import java.util.List;
import java.util.Iterator;
public class Test5 {
    private Test5() {}
    
    public static <T extends Comparable<? super T>>
        List<T> union(List<T> L1, List<T> L2, List<T> ret) {
        
        Iterator<T> iterL1 = L1.iterator();
        Iterator<T> iterL2 = L2.iterator();
        T val1 = null;
        T val2 = null;
        
        if (iterL1.hasNext() && iterL2.hasNext()) {
            val1 = iterL1.next();
            val2 = iterL2.next();
        }
        
        //注意与Test4的区别
        while (val1 != null || val2 != null) {
            if (val1 != null && val2 != null && val1.compareTo(val2) == 0) {
                ret.add(val1);
                val1 = iterL1.hasNext() ? iterL1.next() : null;
                val2 = iterL2.hasNext() ? iterL2.next() : null;
            }
            if (val2 != null && (val1 == null || val1.compareTo(val2) > 0)) {
                ret.add(val2);
                val2 = iterL2.hasNext() ? iterL2.next() : null;
            }
            if (val1 != null && (val2 == null || val1.compareTo(val2) < 0)) {
                ret.add(val1);
            } 
        }
        
        return ret;
    }    
}