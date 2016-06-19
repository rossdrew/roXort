package com.rox;

/**
 * Created by Ross on 19/06/2016.
 */
public class QuickSort {
    public Comparable[] sort(Comparable[] list) {
        int listSize = list.length;

        if (listSize < 2){
            return list;
        }

        int pivot = listSize - 1;

        list = sortAroundPivot(list, pivot);

        return list;
    }

    private Comparable[] sortAroundPivot(Comparable[] list, int pivot) {
        if (list[0].compareTo(list[pivot]) > 0){
            Comparable tmp = list[pivot];
            list[pivot] = list[0];
            list[0] = tmp;
        }

        return list;
    }
}
