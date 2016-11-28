package com.rox.search;

import com.rox.sort.Sorter;

import java.util.Arrays;

/**
 * (Binary / Half Interval / Logarithmic) Search
 *
 * In a sorted array of {@link Comparable} items the middle element can be compared to the value being searched for.
 * If the provided value is less than that found, the entire second half og the array can be discarded, if lower,
 * the first half.
 * This means you can reduce the search space logarithmically.  Decreasing search time drastically.
 *
 * @Author Ross W. Drew
 */
public class BinarySearch implements Searcher{
    private Comparable[] searchSpace;

    public BinarySearch(Comparable[] sortedItems){
        searchSpace = sortedItems;
    }

    public int search(Comparable searchTerm){
        if (searchSpace.length < 1)
            return -1;

        return binarySearch(searchTerm, 0, searchSpace.length - 1);
    }

    private int binarySearch(Comparable searchTerm, int start, int end) {
        int guess = middleOfRange(start, end);
        int guessResult = searchSpace[guess].compareTo(searchTerm);

        if (guessResult == 0)
            return guess;
        else if (start >= end)
            return -1;
        else if (guessResult <= -1)
            return binarySearch(searchTerm, guess+1, end);
        else // (guessResult >=  1)
            return binarySearch(searchTerm, start, guess-1);
    }

    private int middleOfRange(int from, int to){
        return from + ((to-from) / 2);
    }
}
