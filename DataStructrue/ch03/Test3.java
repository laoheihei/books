//ʵ��MylinkedList��contains����
public class Test3 {
    public boolean contains(T x) {
        Node p = header;
        //�˾��Test1�Ĵ���һ��һ��
        while ((p = p.next)!= trailer && (p.data != x));
        
        return p != trailer;
    }
}