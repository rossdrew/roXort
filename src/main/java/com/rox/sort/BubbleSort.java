package com.rox.sort;

/**
 * Bubble Sort
 *
 * Stable: Yes
 *
 * Continually move through the array start to finish comparing pairs
 * and swapping them so that the higher number is on the right. The
 * higher number will "bubble" to the end.
 *
 * 1. Move through the array (0..n) and bubble, leaving a sorted
 *    number at the end.
 * 2. Start over and move through skipping the sorted/bubbled at
 *    the end (0..n-1), leaving two sorted numbers at the end.
 * 3. Continue till all numbers are sorted or no switches happen on
 *    a pass
 *
 *
 * @author Ross W. Drew
 */
public class BubbleSort implements Sorter {
    public Comparable[] sort(Comparable[] list) {
        for (int i=list.length-1; i>=0; i--){
            if (executeBubblePass(list, i) < 1)
                break;
        }

        return list;
    }

    /**
     * Execute a bubble pass through the array, switching numbers
     * so the higher is on the right
     *
     * @param list to be sorted
     * @param limit of where to sort to
     * @return number of switches made during the pass
     */
    private int executeBubblePass(Comparable[] list, int limit) {
        int switches = 0;

        for (int i=0; i<limit; i++){
            if (list[i].compareTo(list[i+1]) > 0){
                Comparable tmp = list[i+1];
                list[i+1] = list[i];
                list[i] = tmp;
                switches++;
            }
        }

        return switches;
    }
}
