package com.rox;

/**
 * QuickSort
 * Sort an array of elements by splitting into sub arrays of
 * items higher and lower than a pivot point, i.e.
 *
 * 1. Pick a pivot
 * 2. Sort lower items to left, higher to right
 * 3. Create two arrays from either side and recursively sort
 *
 * Pivot Selection
 * Currently using the 'Lomuto partition scheme' pivot selection method,
 * in that the pivot is always the last element in the array
 *
 * XXX Other Methods to look at and improve performance on sorted or fully equal lists
 * - Hoare partition scheme
 * - Random pivot
 * - Middle pivot
 *
 * @author Ross W. Drew
 */
public class QuickSort {
    public enum PivotSelection {LOMUTO};

    private PivotSelection pivotSelection = PivotSelection.LOMUTO;

    public Comparable[] sort(Comparable[] list) {
        quickSort(list);
        return list;
    }

    private void quickSort(Comparable[] list) {
        int listSize = list.length;

        if (listSize < 2){
            return;
        }

        int pivot = sortAroundPivot(list, selectPivotPoint(list));
        sortLeft(list, pivot);
        sortRight(list, pivot);
    }

    private int selectPivotPoint(Comparable[] list){
        switch (pivotSelection){
            case LOMUTO:
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
     * Sort array to have items greater than that at the pivot to it's right
     *
     * XXX Probably a nicer way to do this than two loops
     *
     * @param list to be sorted
     * @param pivot point, usually rightmost element
     * @return location in array where pivot now resides
     */
    private int sortAroundPivot(Comparable[] list, int pivot) {
        Comparable[] newList = new Comparable[list.length];

        int leftIndex = newList.length-1;
        int rightIndex = 0;

        for (int i=0; i< list.length; i++){
            if (list[i].compareTo(list[pivot]) >= 0){
                newList[leftIndex--] = list[i];
            }else{
                newList[rightIndex++] = list[i];
            }
        }

        for (int i=0; i< list.length; i++){
            list[i] = newList[i];
        }

        return rightIndex;
    }
}
