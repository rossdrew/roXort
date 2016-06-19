package com.rox.sort;

import com.rox.QuickSort;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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

        System.out.println(Arrays.toString(result));

        assertEquals(1, result[0]);
        assertEquals(42, result[1]);
        assertEquals(100, result[2]);
    }

    @Test
    public void testSortUnsortedComparableListWithLowPivot(){
        Comparable[] list = new Comparable[] {42, 100, 1};
        Comparable[] result = sort.sort(list);

        System.out.println(Arrays.toString(result));

        assertEquals(1, result[0]);
        assertEquals(42, result[1]);
        assertEquals(100, result[2]);
    }
}
