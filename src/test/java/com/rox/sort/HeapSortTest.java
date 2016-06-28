package com.rox.sort;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertSame;

/**
 * @Author Ross W. Drew
 */
public class HeapSortTest extends SorterTest {
    private Sorter sort = null;

    @Before
    public void setUp(){
        sort = new HeapSort();
    }

    @Override
    public Sorter getSorter() {
        return new HeapSort();
    }

    public void testUnstablility(){
        Integer i1 = 43;
        Integer i2 = 43;
        Integer i3 = 42;

        Comparable[] list = new Comparable[] {i1, i2, i3};
        Comparable[] result = getSorter().sort(list);

        assertSame(i3, result[0]);
        assertSame(i2, result[1]);
        assertSame(i1, result[2]);
    }
}
