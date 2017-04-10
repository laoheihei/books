class SingleListSorted {
    SingleListSorted() {
        size = 0;
        head = new Node(null, null);
    }
    private int size;
    private Node<Comparable> head;
    private static class Node<Comparable> {
        Comparable data;
        Node<Comparable> next;
        public Node(Comparable d, Node<Comparable> n) {
            data = d;
            next = n;
        }
    }
    boolean add(Comparable x) {
        if (!contains(x)) {
            Node<Comparable> p = head.next;
            Node<Comparable> q = head;
            while (p != null && p.data.compareTo(x) <= 0) {
                q = p;
                p = p.next;
            }
            q.next = new Node<Comparable>(x, p);
            size++;
            return true;
        }
        return false;
    }
    boolean remove(Comparable x) {
        if (contains(x)) {
            Node<Comparable> p = head.next;
            Node<Comparable> q = head;
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
    
    int size() { return size; }
    
    void print() {
        Node<Comparable> p = head.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    
    boolean contains(Comparable x) {
        Node<Comparable> p = head;
        while ((p = p.next) != null && p.data.compareTo(x) < 0);
        return p != null;
    }
}







