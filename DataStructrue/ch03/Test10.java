//提供对MyLinkedList的removeAll方法的实现
public class Test10 {
    private Test10() {}
    public void removeAll(Iterable<? extends T> items) {
        for (T t : items) {
            Iterator<T> it = iterator();    
            while (it.hasNext()) {
                if (it.next() == t)
                    it.remove();
            }
        }
    }
}