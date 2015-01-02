package QuestionOne;

import java.util.Iterator;

public class PriorityQueue<T extends Comparable> implements Iterable<T> {

    private BinaryHeap<T> heap;


    public PriorityQueue() {
        heap = new BinaryHeap<T>();
    }

    public PriorityQueue(T[] elements) {
        heap = new BinaryHeap<T>(elements);
    }



    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
