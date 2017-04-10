//单链表，只有头节点
class SingleList<T> {
    private Node<T> head;
    private int size;
    
    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E e, Node<E> n) {
            data = e;
            next = n;
        }
    }
    
    public SingleList() {
        size = 0;
        head = new Node(null, null);
    }
    
    public int size() { return size; }
    
    public void print() {
        Node<T> p = head.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    
    public boolean contains(T x) {
        Node<T> p = head;
        while ((p = p.next) != null && !p.data.equals(x));
        
        return p != null;
    }
    public boolean addIfNotExist(T x) {
        if (!contains(x)) {
            //加至头
            Node<T> p = new Node(x, head.next);
            head.next = p;
            size++;
            return true;
        } 
        
        return false;
    }
    
    public boolean removeIfExist(T x) {
        if (contains(x)) {
            Node<T> p = head.next,
                    q = head;
            
            while (!p.data.equals(x)) {
                q = p;
                p = p.next;
            }
            q.next = p.next;
            size--;
            return true;
        }
        
        return false;
    }
}