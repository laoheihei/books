//��������������ı�L1��L2��L1��L2�Ľ���
import java.util.Iterator;
import java.util.List;
public class Test4 {
    private Test4() {}
    
    public static <T extends Comparable<? super T>> 
        List<T> intersection(List<T> L1, List<T> L2, List<T> ret) {
        
        Iterator<T> iterL1 = L1.iterator();
        Iterator<T> iterL2 = L2.iterator();
        T val1 = null;
        T val2 = null;
        
        if (iterL1.hasNext() && iterL2.hasNext()) {
            val1 = iterL1.next();
            val2 = iterL2.next();
        }
        
        //�󽻼�������������һ��List�е�ֵѭ����ϣ�Ҳ��val1||val2==null
        while (val1 != null && val2 != null) {
            int result = val1.compareTo(val2);
            if (result == 0) {
                ret.add(val1);
                val1 = iterL1.hasNext() ? iterL1.next() : null;
                val2 = iterL2.hasNext() ? iterL2.next() : null;
            }
            else if (result > 0) {
                val2 = iterL2.hasNext() ? iterL2.next() : null;
            }
            else
                val1 = iterL1.hasNext() ? iterL1.next() : null;
        }
        
        return ret;
    }
}