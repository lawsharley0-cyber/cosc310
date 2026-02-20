package chapter9;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SortedArrayListPriorityQueue<T> implements PriorityQueue<T> {

    private static class Entry<T> implements Comparable<Entry<T>> {
        final int priority;
        final T data;
        Entry(int priority, T data) {
            this.priority = priority;
            this.data = data;
        }

        @Override
        public int compareTo(Entry<T> o) {
            return this.priority - o.priority;
        }
    }

    private final ArrayList<Entry<T>> list;

    public SortedArrayListPriorityQueue() {
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(int priority, T data) {
        // TODO: insert so list is sorted by priority ASC (lower number is higher priority)
        Entry<T> entry = new Entry<>(priority, data);

        int i = 0;
        while (i < list.size() && list.get(i).priority <= priority) {
            i++;
        }

        list.add(i, entry);
    }

    @Override
    public T dequeue() throws Exception {
        // TODO: remove index 0
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(0).data;
    }

    @Override
    public T front() throws Exception {
        // TODO: return index 0
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(0).data;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}