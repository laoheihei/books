public class MyLinkedList<T> {
    private Node<T> header;
    private Node<T> trailer;
    private int size;
    private int modCount;
    
    private static class Node<E> {
        E data;
        Node prev;
        Node succ;
        public Node(E d, Node<E> p, Node<E> s) {
            data = d; prev = p; succ =s;
        }
    }
    
    public MyLinkedList() {
        size = 0;
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.succ = trailer;
        modCount++;
    }
    
    public void clear() {
        size = 0;
        header.succ = trailer;
        trailer.prev =  header;
        modCount++;
    }
    
    public boolean isEmpty() { return size == 0; }
        
    public boolean add(T x) {
        add(size, x);
        return true;
    }

    public void add(int index, T x) {
        //注意此处是getNode(index, 0, size)而不是getNode(index).
        //getNode(index)在getNode(size)时失败.
        //而add(T x)需要getNode(size).
        Node<T> p = getNode(index, 0, size);
        addBefore(p, x);
    }
    
    public T get(int index) {
        Node<T> p = getNode(index);
        return p.data;
    }
    
    public T set(int index, T x) {
        Node<T> p = getNode(index);
        T removed = p.data;
        p.data = x;
        return removed;
    }
    
    public T remove(int index) {
        Node<T> p = getNode(index);
        
        return remove(p);
    }

    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node(x, p.prev, p);
        p.prev.succ = newNode;
        p.prev = newNode;
        size++;
        modCount++;
    }
    private T remove(Node<T> p) {
        T removed = p.data;
        p.prev.succ = p.succ;
        p.succ.prev = p.prev;
        size--;
        modCount++;
        return removed;
    }
    
    //getNode(int index)为set()、get()、remove()服务.
    private Node<T> getNode(int index) {
        // 0 <= index <= size - 1
        return getNode(index, 0, size - 1);
    }
    
    //getNode(int index, int lo, int hi)为add()服务.
    private Node<T> getNode(int index, int lower, int upper) {
        if (index < 0 || index < upper) throw new ArrayIndexOutOfBoundsException();
        Node<T> p = null;
        int mi = size / 2;
        p = (index <= mi) ? header : trailer;
        if (p == header) {
            while (0 <= index--)
                p = p.succ;
        } else {
            while (index++ < size)
                p = p.prev;
        }
        
        return p;
    }
    
    public java.util.Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements java.util.Iterator<T> {
        private int expectedModCount = modCount;
        private Node<T> current = header.succ;
        private boolean okToRemove = false;
        
        public boolean hasNext() { return current != trailer; }
        
        public T next() {
            if (expectedModCount != modCount)
                throw new java.util.ConcurrentModificationException();
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            okToRemove = true;
            T ret = current.data;
            current = current.succ;
            return ret;            
        }
        
        public void remove() {
            if (expectedModCount != modCount)
                throw new java.util.ConcurrentModificationException();
            if (!okToRemove)
                throw new IllegalStateException();
            
            //这里再看一下，自己写的时候写的有问题.
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }
}











