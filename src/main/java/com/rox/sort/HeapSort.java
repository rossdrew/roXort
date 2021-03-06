package com.rox.sort;

import com.rox.struc.Heap;

/**
 * Heap Sort
 *
 * Stable: No
 *
 * Compile a {@link com.rox.struc.Heap Heap} data structure from the items to be sorted
 * then continually use the top item (highest) and resort the heap.
 *
 * 1. Create a Heap
 * 2. Swap the first (which will be the highest in heap) and last heap items.
 *      - The last item in the structure is now sorted, the unsorted heap is one item smaller
 * 3. Sift the now top heap item into it's ordered position in the heap
 *      - It is a heap again
 * 4. Do this until all items are sorted and there's no unsorted heap left
 *
 * @author Ross W. Drew
 */
public class HeapSort implements Sorter {
    public Comparable[] sort(Comparable[] list) {
        if (list.length < 2)
            return list;

        list = heapify(list);
        return heapSort(list, list.length);
    }

    /**
     * Recursively Heapsort the given list.
     *
     * @param list [0..n] where 0-heapLength is a heap and heapLength to n is ordered
     * @param heapSize of heap inside array
     * @return ordered list
     */
    private Comparable[] heapSort(Comparable[] list, int heapSize){
        if (heapSize < 2)
            return list;

        int lastItem = heapSize - 1;
        swapNodes(list, 0, lastItem);
        siftDown(list, 0, lastItem);

        return heapSort(list, lastItem);
    }

    /**
     * Recursively sift item down list until it's in it's proper place in the heap
     *
     * XXX Better done in the Heap structure?
     *
     * @param list of items representing an out of order heap
     * @param siftItemIndex of the item out of place
     * @param heapLength length of heap, a sub array of the given list
     */
    private void siftDown(Comparable[] list, int siftItemIndex, int heapLength){
        if (heapLength < 2)
            return;

        int swapDownTo = siftItemIndex;
        int leftChildIndex = Heap.getIndexLocationOfLeftChild(swapDownTo);
        int rightChildIndex = leftChildIndex + 1;

        if (leftChildIndex < heapLength && list[leftChildIndex].compareTo(list[swapDownTo]) > 0)
            swapDownTo = leftChildIndex;

        if (rightChildIndex < heapLength && list[rightChildIndex].compareTo(list[swapDownTo]) > 0)
            swapDownTo = rightChildIndex;

        if (swapDownTo != siftItemIndex) {
            swapNodes(list, swapDownTo, siftItemIndex);
            siftDown(list, swapDownTo, heapLength);
        }
    }

    private Comparable[] heapify(Comparable[] list){
        Heap heap = new Heap();
        for (Comparable i : list){
            heap.insert(i);
        }

        return heap.getData();
    }

    private void swapNodes(Comparable[] list, int nodeA, int nodeB) {
        Comparable tmp = list[nodeA];
        list[nodeA] = list[nodeB];
        list[nodeB] = tmp;
    }
}
