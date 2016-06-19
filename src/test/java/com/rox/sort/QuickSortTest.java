package com.rox.sort;

import com.rox.QuickSort;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Ross on 19/06/2016.
 */
public class QuickSortTest {
    private QuickSort sort;

    @Before
    public void setUp(){
        sort = new QuickSort();
    }

    @Test
    public void testSortEmptyComparableList(){
        Comparable[] list = new Comparable[] {};
        Comparable[] result = sort.sort(list);

        assertEquals(list, result);
    }

    @Test
    public void testSortSingleComparableList(){
        Comparable[] list = new Comparable[] {42};
        Comparable[] result = sort.sort(list);

        assertEquals(list, result);
    }

    @Test
    public void testSortDoubleSortedComparableList(){
        Comparable[] list = new Comparable[] {42, 43};
        Comparable[] result = sort.sort(list);

        assertEquals(42, result[0]);
        assertEquals(43, result[1]);
    }

    @Test
    public void testSortDoubleUnsortedComparableList(){
        Comparable[] list = new Comparable[] {43, 42};
        Comparable[] result = sort.sort(list);

        assertEquals(42, result[0]);
        assertEquals(43, result[1]);
    }

    @Test
    public void testSortUnsortedComparableListWithHighPivot(){
        Comparable[] list = new Comparable[] {42, 1, 100};
        Comparable[] result = sort.sort(list);

        assertEquals(1, result[0]);
        assertEquals(42, result[1]);
        assertEquals(100, result[2]);
    }

    @Test
    public void testSortUnsortedComparableListWithLowPivot(){
        Comparable[] list = new Comparable[] {42, 100, 1};
        Comparable[] result = sort.sort(list);

        assertEquals(1, result[0]);
        assertEquals(42, result[1]);
        assertEquals(100, result[2]);
    }

    @Test
    public void testSortReversedList(){
        Comparable[] list = new Comparable[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Comparable[] result = sort.sort(list);

        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result[2]);
        assertEquals(3, result[3]);
        assertEquals(4, result[4]);
        assertEquals(5, result[5]);
        assertEquals(6, result[6]);
        assertEquals(7, result[7]);
        assertEquals(8, result[8]);
        assertEquals(9, result[9]);
        assertEquals(10, result[10]);
    }

    @Test
    public void testSortRandomList(){
        Comparable[] list = new Comparable[] {7, 4, 8, 10, 6, 5, 9, 0, 2, 1, 3};
        Comparable[] result = sort.sort(list);

        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result[2]);
        assertEquals(3, result[3]);
        assertEquals(4, result[4]);
        assertEquals(5, result[5]);
        assertEquals(6, result[6]);
        assertEquals(7, result[7]);
        assertEquals(8, result[8]);
        assertEquals(9, result[9]);
        assertEquals(10, result[10]);
    }
}
