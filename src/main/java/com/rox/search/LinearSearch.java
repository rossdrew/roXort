package com.rox.search;

/**
 * Linear Search
 *
 * For completelness and comparing I present, the linear search.
 *
 * Step through the search space until we find what we are looking for.
 * No order required or expected.
 */
public class LinearSearch<ComparableSearchTarget extends Comparable<ComparableSearchTarget>> implements Searcher<ComparableSearchTarget> {
    private ComparableSearchTarget[] searchSpace;

    public LinearSearch(ComparableSearchTarget[] searchSpace) {
        this.searchSpace = searchSpace;
    }

    public int search(ComparableSearchTarget searchTerm) {
        for (int i = 0; i<searchSpace.length; i++){
            if (searchSpace[i].compareTo(searchTerm) == 0)
                return i;
        }

        return -1;
    }
}
