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

    @Override
    public boolean isStable() {
        return true;
    }
}
