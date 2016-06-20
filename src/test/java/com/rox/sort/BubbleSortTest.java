package com.rox.sort;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testStablility(){
        //TODO test if this is a stable implementation
    }
}
