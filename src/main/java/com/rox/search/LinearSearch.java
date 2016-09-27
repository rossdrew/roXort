package com.rox.search;

/**
 * Linear Search
 *
 * For completelness and comparing I present, the linear search.
 *
 * Step through the search space until we find what we are looking for.
 * No order required or expected.
 */
public class LinearSearch implements Searcher {
    private Comparable[] searchSpace;

    public LinearSearch(Comparable[] searchSpace) {
        this.searchSpace = searchSpace;
    }

    public int search(Comparable searchTerm) {
        for (int i = 0; i<searchSpace.length; i++){
            if (searchSpace[i].compareTo(searchTerm) == 0)
                return i;
        }

        return -1;
    }
}
