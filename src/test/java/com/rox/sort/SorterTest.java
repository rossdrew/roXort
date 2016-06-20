package com.rox.sort;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Common tests which apply to anything extending the {@link Sorter Sorter} interface.
 *
 * @Author Ross W. Drew
 */
public abstract class SorterTest {

    public abstract Sorter getSorter();

    @Test
    public void testSortEmptyComparableList(){
        Comparable[] list = new Comparable[] {};
        Comparable[] result = getSorter().sort(list);

        assertEquals(list, result);
    }

    @Test
    public void testSortSingleComparableList(){
        Comparable[] list = new Comparable[] {42};
        Comparable[] result = getSorter().sort(list);

        assertEquals(list, result);
    }

    @Test
    public void testSortDoubleSortedComparableList(){
        Comparable[] list = new Comparable[] {42, 43};
        Comparable[] result = getSorter().sort(list);

        assertEquals(42, result[0]);
        assertEquals(43, result[1]);
    }

    @Test
    public void testSortDoubleUnsortedComparableList(){
        Comparable[] list = new Comparable[] {43, 42};
        Comparable[] result = getSorter().sort(list);

        assertEquals(42, result[0]);
        assertEquals(43, result[1]);
    }

    @Test
    public void testSortUnsortedComparableListWithHighPivot(){
        Comparable[] list = new Comparable[] {42, 1, 100};
        Comparable[] result = getSorter().sort(list);

        assertEquals(1, result[0]);
        assertEquals(42, result[1]);
        assertEquals(100, result[2]);
    }

    @Test
    public void testSortUnsortedComparableListWithLowPivot(){
        Comparable[] list = new Comparable[] {42, 100, 1};
        Comparable[] result = getSorter().sort(list);

        assertEquals(1, result[0]);
        assertEquals(42, result[1]);
        assertEquals(100, result[2]);
    }

    @Test
    public void testSortReversedList(){
        Comparable[] list = new Comparable[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Comparable[] result = getSorter().sort(list);

        int i = 0;
        assertEquals(0, result[i++]);
        assertEquals(1, result[i++]);
        assertEquals(2, result[i++]);
        assertEquals(3, result[i++]);
        assertEquals(4, result[i++]);
        assertEquals(5, result[i++]);
        assertEquals(6, result[i++]);
        assertEquals(7, result[i++]);
        assertEquals(8, result[i++]);
        assertEquals(9, result[i++]);
        assertEquals(10, result[i++]);
    }

    @Test
    public void testSortRandomList(){
        Comparable[] list = new Comparable[] {7, 4, 8, 10, 6};
        Comparable[] result = getSorter().sort(list);

        int i = 0;
        assertEquals(4, result[i++]);
        assertEquals(6, result[i++]);
        assertEquals(7, result[i++]);
        assertEquals(8, result[i++]);
        assertEquals(10, result[i++]);
    }

    @Test
    public void testSortWithDuplicates(){
        Comparable[] list = new Comparable[] {7, 7, 3, 4, 3, 1, 7};
        Comparable[] result = getSorter().sort(list);

        int i = 0;
        assertEquals(1, result[i++]);
        assertEquals(3, result[i++]);
        assertEquals(3, result[i++]);
        assertEquals(4, result[i++]);
        assertEquals(7, result[i++]);
        assertEquals(7, result[i++]);
        assertEquals(7, result[i++]);
    }
}
