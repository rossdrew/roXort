package com.rox.search;

/**
 * @Author rossdrew
 * @Created 26/09/16.
 */
public class LinearSearchTest extends SearcherTest {
    @Override
    protected Searcher getSearcher(Comparable[] searchSpace) {
        return new LinearSearch(searchSpace);
    }
}
