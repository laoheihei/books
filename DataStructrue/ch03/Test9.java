//提供MyArrayList的addAll方法的实现
public class Test9 {
    private Test9() {}
    
    public void addAll(Iterable<? extends T> items) {
        for (T t : items)
            add(t);
    }
}