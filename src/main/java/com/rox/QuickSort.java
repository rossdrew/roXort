package com.rox;

/**
 * Created by Ross on 19/06/2016.
 */
public class QuickSort {
    public Comparable[] sort(Comparable[] list) {
        quickSort(list);
        return list;
    }

    private void quickSort(Comparable[] list) {
        int listSize = list.length;

        if (listSize < 2){
            return;
        }

        int pivot = sortAroundPivot(list, listSize - 1);

        Comparable[] left = new Comparable[pivot];
        System.arraycopy(list, 0, left, 0, pivot);
        quickSort(left);
        System.arraycopy(left, 0, list, 0, left.length);

    }

    /**
     * Sort array to have items greater than that at the pivot to it's right
     *
     * @param list to be sorted
     * @param pivot point, usually rightmost element
     * @return location in array where pivot now resides
     */
    private int sortAroundPivot(Comparable[] list, int pivot) {
        if (list[0].compareTo(list[pivot]) > 0){
            Comparable tmp = list[pivot];
            list[pivot] = list[0];
            list[0] = tmp;
            return 0;
        }

        return pivot;
    }
}
