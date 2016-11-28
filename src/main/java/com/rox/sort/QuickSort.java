package com.rox.sort;

/**
 * QuickSort
 * 
 * Sort an array of elements by splitting into sub arrays of
 * items higher and lower than a pivot point, i.e.
 *
 * 1. Pick a pivot
 * 2. Sort lower items to left, higher to right
 * 3. Create two arrays from either side and recursively sort in the same way
 *
 * Pivot Selection: the only option for now is that the pivot is always the last element in the array
 * Partition Scheme: Currently only using the 'Lomuto partition scheme' method,
 *
 * XXX Other Methods to look at and improve performance on sorted or fully equal lists
 * - Hoare partition scheme
 * - Random pivot
 * - Middle pivot
 *
 * @author Ross W. Drew
 */
public class QuickSort implements Sorter {
    public enum PivotSelection {LAST_ITEM}

    private final PivotSelection pivotSelection = PivotSelection.LAST_ITEM;

    public Comparable[] sort(Comparable[] list) {
        quickSort(list);
        return list;
    }

    private void quickSort(Comparable[] list) {
        if (list.length < 2){
            return;
        }

        int pivot = lomutoPartition(list, selectPivotPoint(list));

        sortLeft(list, pivot);
        sortRight(list, pivot);
    }

    /**
     * Select pivot point based on pivot selection method selected
     *
     * XXX For now this is only LAST_ITEM
     *
     * @param list from which to select a pivot
     * @return an index in the array to a chosen pivot point
     */
    private int selectPivotPoint(Comparable[] list){
        switch (pivotSelection){
            case LAST_ITEM:
            default:
                return list.length - 1;
        }
    }

    /**
     * Split array into right-of-pivot and sort
     */
    private void sortRight(Comparable[] list, int pivot) {
        Comparable[] right = new Comparable[list.length - (pivot+1)];
        System.arraycopy(list, pivot+1, right, 0, right.length);
        quickSort(right);
        System.arraycopy(right, 0, list, pivot+1, right.length);
    }

    /**
     * Split array into left-of-pivot and sort
     */
    private void sortLeft(Comparable[] list, int pivot) {
        Comparable[] left = new Comparable[pivot];
        System.arraycopy(list, 0, left, 0, pivot);
        quickSort(left);
        System.arraycopy(left, 0, list, 0, left.length);
    }

    /**
     * Lomuto Partition Scheme
     * -----------------------
     * Sort array to have items greater than that at the pivot to it's right
     *
     * XXX Probably a nicer way to do this than two loops
     *
     * @param list to be sorted
     * @param pivot point, usually rightmost element
     * @return location in array where pivot now resides
     */
    private int lomutoPartition(Comparable[] list, int pivot) {
        Comparable[] newList = new Comparable[list.length];

        int leftIndex = newList.length-1;
        int rightIndex = 0;

        for (Comparable aList : list) {
            if (aList.compareTo(list[pivot]) >= 0) {
                newList[leftIndex--] = aList;
            } else {
                newList[rightIndex++] = aList;
            }
        }

        System.arraycopy(newList, 0, list, 0, list.length);

        return rightIndex;
    }
}
