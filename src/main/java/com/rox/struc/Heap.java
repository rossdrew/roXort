package com.rox.struc;

/**
 * Array based heap structure
 *
 * @Author Ross W. Drew
 */
public class Heap {
    private Comparable[] heap;

    public Heap(Comparable[] data){
        heap = new Comparable[0];
        for (Comparable item : data){
            insert(item);
        }
    }

    public Heap(){
        heap = new Comparable[0];
    }

    /**
     * Insert an item to this heap
     *
     * @param item to be inserted into heap
     */
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
     * Get expected parent index of child in binary tree
     *
     * @param child index to find parent of
     * @return parent index in binary tree array
     */
    public static int getIndexLocationOfParent(int child){
        if (child < 3)
            return 0;

        return (child - ((child / 2)+1));
    }

    public static int getIndexLocationOfLeftChild(int parent){
        return (parent*2)+1;
    }
}
