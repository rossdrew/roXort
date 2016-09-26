package com.rox.search;

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
