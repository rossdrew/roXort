package com.rox.sort;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertSame;

public class BubbleSortTest extends SorterTest {
    private BubbleSort sort;

    @Before
    public void setUp(){
        sort = new BubbleSort();
    }


    @Override
    public Sorter getSorter() {
        return sort;
    }

    @Test
    public void testStablility(){
        Integer i1 = 43;
        Integer i2 = 43;
        Integer i3 = 42;

        Comparable[] list = new Comparable[] {i1, i2, i3};
        Comparable[] result = getSorter().sort(list);

        assertSame(i3, result[0]);
        assertSame(i1, result[1]);
        assertSame(i2, result[2]);
    }
}
