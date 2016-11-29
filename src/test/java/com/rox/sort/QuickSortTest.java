package com.rox.sort;

import org.junit.Before;

public class QuickSortTest extends SorterTest {
    private QuickSort sort;

    @Before
    public void setUp(){
        sort = new QuickSort();
    }


    @Override
    public Sorter getSorter() {
        return sort;
    }

    @Override
    public boolean isStable() {
        return false;
    }
}
