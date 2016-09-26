package com.rox.search;


/**
 * @Author Ross W. Drew
 */
public class BinarySearchTest extends SearcherTest{
    @Override
    protected Searcher getSearcher(Comparable[] searchSpace) {
        return new BinarySearch(searchSpace);
    }

}
