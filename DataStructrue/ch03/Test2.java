//只调整链(而不是数据)来交换两个相邻的元素
public class Test2 {
    private Test2() {}
    //单链表: 交换p与afterP
    public static void swapWithNext(Node beforeP) {
        Node p = beforeP.next;
        Node afterP = p.next;
        
        beforeP.next = afterP;
        p.next = afterP.next;
        afterP.next = p;
    }
    
    //双链表：交换p与afterP
    public static void sawpWithNext(Node p) {
        Node beforeP = p.prev;
        Node afterP = p.next;
        
        beforeP.next = afterP;
        p.next = afterP.next;
        afterP.next = p;
       
        //此句是重点，p.next值已经改变，要想到
        p.next.prev = p;
        p.prev = afterP;
        afterP.prev = beforeP;
    }
}