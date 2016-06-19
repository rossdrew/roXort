package com.rox.sort;

import org.junit.Before;

/**
 * @Author Ross W. Drew
 */
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
}
