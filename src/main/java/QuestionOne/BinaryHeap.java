package QuestionOne;

import java.util.*;

public class BinaryHeap<T extends Comparable<T>> implements Iterable {

    private List<T> elements;


    public BinaryHeap() {
        elements = new ArrayList<T>();
    }

    public BinaryHeap(T[] elements) {
        this.elements = new ArrayList<T>(Arrays.asList(elements));
        int heapfiyBegin = (int) (Math.floor(this.elements.size() / 2) - 1);
        for (int i = heapfiyBegin; i >= 0; i--) {
            minHeapify(i);
        }
    }

    private void minHeapify(int currentNodeIndex) {
        int leftChildIndex;
        int rightChildIndex;
        int smallestIndex = currentNodeIndex;
        leftChildIndex = getLeftChildIndex(currentNodeIndex);
        rightChildIndex = getRightChildIndex(currentNodeIndex);

        if (isValidNode(leftChildIndex) && isASmallerThenB(leftChildIndex, smallestIndex)) {
            smallestIndex = leftChildIndex;
        }

        if (isValidNode(rightChildIndex) && isASmallerThenB(rightChildIndex, smallestIndex)) {
            smallestIndex = rightChildIndex;
        }
        if (smallestIndex != currentNodeIndex) {
            swap(currentNodeIndex, smallestIndex);
            minHeapify(smallestIndex);

        }
    }

    public T poll() throws EmptyHeapException {
        T result;
        if (elements.size() != 0) {
            result = elements.get(0);
            swap(0, elements.size() - 1);
            elements.remove(elements.size() - 1);
            minHeapify(0);
            return result;
        } else {
            throw new EmptyHeapException("Cannot retrieve an element from an empty stack");
        }
    }

    private void swap(int indexOne, int indexTwo) {
        Collections.swap(elements, indexOne, indexTwo);
    }

    private boolean isValidNode(int index) {
        return index < elements.size();
    }

    private boolean isASmallerThenB(int aIndex, int bIndex) {
        return elements.get(aIndex).compareTo(elements.get(bIndex)) < 0;
    }

    private int getRightChildIndex(int Index) {
        return (2 * Index) + 2;
    }

    private int getLeftChildIndex(int Index) {
        return  (2 * Index) + 1;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

}
