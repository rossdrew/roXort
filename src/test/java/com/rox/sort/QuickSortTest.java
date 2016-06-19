package com.rox.sort;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
}
