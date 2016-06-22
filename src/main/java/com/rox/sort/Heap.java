package com.rox.sort;

import java.util.Arrays;

/**
 * @Author rossdrew
 * @Created 22/06/16.
 */
public class Heap {
    private Comparable[] heap;

    public Heap(Comparable[] data){
        heap = new Comparable[data.length];

    }

    public Heap(){
        heap = new Comparable[0];
    }
//13,14,15,18
//18,15,14,13
//    15              18
//  13 14    ->     15  14
//                 13
    public void insert(Comparable item) {
        Comparable[] newHeap = new Comparable[heap.length + 1];

        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        newHeap[heap.length] = item;

        bubbleUpItem(newHeap, heap.length);

        heap = newHeap;
    }

    /**
     * Bubble the item up till it has no lower values above it
     *
     * @param heap to bubble
     * @param indexOfItem to bubble
     */
    private void bubbleUpItem(Comparable[] heap, int indexOfItem) {
        if (indexOfItem == 0)
            return;

        int parentIndex = getIndexLocationOfParent(indexOfItem);

        if (heap[parentIndex].compareTo(heap[indexOfItem]) < 0){
            Comparable tmp = heap[indexOfItem];
            heap[indexOfItem] = heap[parentIndex];
            heap[parentIndex] = tmp;

            bubbleUpItem(heap, parentIndex);
        }
    }

    public Comparable[] getData(){
        return heap;
    }

    public int getSize(){
        return heap.length;
    }

    /**
     * Get parent index of child in binary tree
     *
     * @param child index to find parent of
     * @return parent index in binary tree array
     */
    public static int getIndexLocationOfParent(int child){
        int parentIndex = 0;

        if (child > 2){
            parentIndex = child - ((child / 2)+1);
        }

        return parentIndex;
    }
}
