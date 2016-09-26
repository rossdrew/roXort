package com.rox.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class SearcherTest {
    protected abstract Searcher getSearcher(Comparable[] searchSpace);

    @Test
    public void testEmptyList(){
        Searcher search = getSearcher(new String[] {});
        assertEquals(-1 ,search.search("X"));
    }

    @Test
    public void testPositiveSearchOfSingleItem(){
        Searcher search = getSearcher(new String[] {"X"});
        assertEquals(0 ,search.search("X"));
    }

    @Test
    public void testNegativeSearchOfSingleItem(){
        Searcher search = getSearcher(new String[] {"X"});
        assertEquals(-1 ,search.search("Y"));
    }

    @Test
    public void testPositiveSearchOfMoreThanOneItems(){
        Searcher search = getSearcher(new String[] {"X", "Y"});
        assertEquals(1 ,search.search("Y"));
        assertEquals(0 ,search.search("X"));
    }

    @Test
    public void testNegativeSearchOfMoreThanOneItems(){
        Searcher search = getSearcher(new String[] {"X", "Y"});
        assertEquals(-1 ,search.search("Z"));
    }

    @Test
    public void testPositiveSearchOfMultipleItems(){
        Searcher search = getSearcher(new String[] {"A","B","C","D","E","F"});
        assertEquals(5 ,search.search("F"));
        assertEquals(0 ,search.search("A"));
        assertEquals(4 ,search.search("E"));
        assertEquals(1 ,search.search("B"));
        assertEquals(3 ,search.search("D"));
        assertEquals(2 ,search.search("C"));
    }

    @Test
    public void testNegitiveSearchOfMultipleItems(){
        Searcher search = getSearcher(new String[] {"A","B","C","D","E","F"});
        assertEquals(-1 ,search.search("Z"));
    }
}
