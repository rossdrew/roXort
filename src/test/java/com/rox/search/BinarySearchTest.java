package com.rox.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Author Ross W. Drew
 */
public class BinarySearchTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testEmptyList(){
        BinarySearch search = new BinarySearch(new String[] {});
        assertEquals(-1 ,search.find("X"));
    }

    @Test
    public void testPositiveSearchOfSingleItem(){
        BinarySearch search = new BinarySearch(new String[] {"X"});
        assertEquals(0 ,search.find("X"));
    }

    @Test
    public void testNegativeSearchOfSingleItem(){
        BinarySearch search = new BinarySearch(new String[] {"X"});
        assertEquals(-1 ,search.find("Y"));
    }

    @Test
    public void testPositiveSearchOfMoreThanOneItems(){
        BinarySearch search = new BinarySearch(new String[] {"X", "Y"});
        assertEquals(1 ,search.find("Y"));
        assertEquals(0 ,search.find("X"));
    }

    @Test
    public void testNegativeSearchOfMoreThanOneItems(){
        BinarySearch search = new BinarySearch(new String[] {"X", "Y"});
        assertEquals(-1 ,search.find("Z"));
    }

    @Test
    public void testPositiveSearchOfMultipleItems(){
        BinarySearch search = new BinarySearch(new String[] {"A","B","C","D","E","F"});
        assertEquals(5 ,search.find("F"));
        assertEquals(0 ,search.find("A"));
        assertEquals(4 ,search.find("E"));
        assertEquals(1 ,search.find("B"));
        assertEquals(3 ,search.find("D"));
        assertEquals(2 ,search.find("C"));
    }

    @Test
    public void testNegitiveSearchOfMultipleItems(){
        BinarySearch search = new BinarySearch(new String[] {"A","B","C","D","E","F"});
        assertEquals(-1 ,search.find("Z"));
    }
}
