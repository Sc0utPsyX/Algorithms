package Queue;

public interface Queue<T> {

    boolean pushTail(T item);
    boolean pushHead(T item);

    T poolTail();
    T poolHead();

    T peekTail();
    T peekHead();

    boolean isEmpty();

    boolean isFull();

}
