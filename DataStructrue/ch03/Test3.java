//实现MylinkedList的contains例程
public class Test3 {
    public boolean contains(T x) {
        Node p = header;
        //此句和Test1的错误一起看一下
        while ((p = p.next)!= trailer && (p.data != x));
        
        return p != trailer;
    }
}