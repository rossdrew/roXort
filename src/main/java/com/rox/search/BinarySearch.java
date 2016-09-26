package com.rox.search;

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
public class BinarySearch {
    private Comparable[] searchSpace;

    public BinarySearch(Comparable[] items){
        searchSpace = items;
    }

    public int find (Comparable searchTerm){
        if (searchSpace.length < 1)
            return -1;

        return find(searchTerm, 0, searchSpace.length - 1);
    }

    private int find(Comparable searchTerm, int start, int end) {
        int guess = middleOfRange(start, end);
        int guessResult = searchSpace[guess].compareTo(searchTerm);

        //System.out.println(">> Search Cycle of '" + Arrays.toString(searchSpace) + "':\n\t[" + start + "-" + end + "] guess: " + guess + " = " + guessResult);

        if (guessResult == 0)
            return guess;
        else if (start == end)
            return -1;
        else if (guessResult < 0)
            return find(searchTerm, guess+1, end);
        else
            return find(searchTerm, start, guess-1);
    }

    private int middleOfRange(int from, int to){
        return from + ((to-from) / 2);
    }
}
