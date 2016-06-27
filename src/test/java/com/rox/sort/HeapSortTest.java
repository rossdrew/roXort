package com.rox.sort;

import org.junit.Before;

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
}
