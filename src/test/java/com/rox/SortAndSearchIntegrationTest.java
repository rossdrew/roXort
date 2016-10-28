package com.rox;

import com.rox.search.LinearSearch;
import com.rox.search.Searcher;
import com.rox.sort.BubbleSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortAndSearchIntegrationTest {

    @Test
    public void testSearchingAnUnorderedList(){
        Integer[] list = new Integer[] {1,9,2,8,3,0,5,4,7,6};
        Searcher searcher = new LinearSearch(new BubbleSort().sort(list));

        assertEquals(searcher.search(9), 9);
        assertEquals(searcher.search(1), 1);
        assertEquals(searcher.search(4), 4);
    }
}
