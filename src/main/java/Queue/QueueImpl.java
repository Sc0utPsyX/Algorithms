package Queue;

import java.util.List;
import java.util.stream.IntStream;

public class QueueImpl<T> implements Queue<T> {
    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(10);
        queue.pushTail(0);
        queue.pushTail(1);
        queue.pushTail(2);
        queue.pushTail(3);
        queue.pushTail(4);
        queue.pushTail(5);
        queue.pushHead(11);
        queue.pushTail(5);
        System.out.println(queue);
        queue.poolHead();
        System.out.println(queue);
        queue.poolTail();
        System.out.println(queue);
    }


    private final Object[] data;
    private int tail;

    public QueueImpl(int size) {
        this.data = new Object[size];
        tail = 0;
    }

    @Override
    public boolean pushHead(T item) {
        if (isFull()) {
            return false;
        }
        for (int i = data.length - 1; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = item;
        tail++;
        return true;
    }

    @Override
    public boolean pushTail(T item) {
        if (isFull()) {
            return false;
        }
        data[tail++] = item;
        return true;
    }

    @Override
    public T poolHead() {
        if (isEmpty()) {
            return null;
        }
        T peek = peekHead();
        tail--;
        for (int i = 0; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        return peek;
    }

    @Override
    public T poolTail() {
        if (isEmpty()) {
            return null;
        }
        T peek = peekTail();
        tail--;
        return peek;
    }

    @Override
    public T peekHead() {
        if (isEmpty()) {
            return null;
        }
        return (T) data[0];
    }

    @Override
    public T peekTail() {
        if (isEmpty()) {
            return null;
        }
        return (T) data[tail];
    }

    @Override
    public boolean isEmpty() {
        return tail == 0;
    }

    @Override
    public boolean isFull() {
        return tail == data.length;
    }

    @Override
    public String toString() {
        List<String> dataInQueue = IntStream.range(0, tail)
                .mapToObj(i -> data[i])
                .map(String::valueOf)
                .toList();

        return "[" + String.join(", ", dataInQueue) + "]";
    }

}
