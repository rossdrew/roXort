package com.rox.sort;

import com.rox.struc.Heap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Author Ross W. Drew
 */
public class HeapTest {
    private Heap testHeap;

    @Before
    public void setUp(){
        testHeap = new Heap();
    }

    @Test
    public void testIndexLocationOfLeftChild(){
        assertEquals(3, Heap.getIndexLocationOfLeftChild(1));
        assertEquals(5, Heap.getIndexLocationOfLeftChild(2));
        assertEquals(7, Heap.getIndexLocationOfLeftChild(3));
        assertEquals(9, Heap.getIndexLocationOfLeftChild(4));
        assertEquals(49, Heap.getIndexLocationOfLeftChild(24));
    }

    @Test
    public void testIndexLocationOfParent(){
        assertEquals(0, Heap.getIndexLocationOfParent(0));
        assertEquals(0, Heap.getIndexLocationOfParent(1));
        assertEquals(0, Heap.getIndexLocationOfParent(2));
        assertEquals(1, Heap.getIndexLocationOfParent(3));
        assertEquals(1, Heap.getIndexLocationOfParent(4));
        assertEquals(2, Heap.getIndexLocationOfParent(5));
        assertEquals(16, Heap.getIndexLocationOfParent(34));
    }

    @Test
    public void testSingleEntryHeapCreation(){
        testHeap = new Heap(new Integer[] {13});

        assertEquals(1, testHeap.getSize());
        assertEquals(13, testHeap.getData()[0]);
    }

    @Test
    public void testHeapCreation(){
        testHeap = new Heap(new Integer[] {13,14,15,18,11,12,17,16});

        assertEquals(8, testHeap.getSize());
        assertEquals(18, testHeap.getData()[0]);
        assertEquals(16, testHeap.getData()[1]);
        assertEquals(17, testHeap.getData()[2]);
        assertEquals(15, testHeap.getData()[3]);
        assertEquals(11, testHeap.getData()[4]);
        assertEquals(12, testHeap.getData()[5]);
        assertEquals(14, testHeap.getData()[6]);
        assertEquals(13, testHeap.getData()[7]);
    }

    @Test
    public void testFirstInsertion(){
        testHeap.insert(13);

        assertEquals(1, testHeap.getSize());
        assertEquals(13, testHeap.getData()[0]);
    }

    @Test
    public void testParentStealingSecondInsertion(){
        testHeap.insert(13);
        testHeap.insert(14);

        assertEquals(2, testHeap.getSize());
        assertEquals(14, testHeap.getData()[0]);
        assertEquals(13, testHeap.getData()[1]);
    }

    @Test
    public void testSecondInPlaceInsertion(){
        testHeap.insert(13);
        testHeap.insert(12);

        assertEquals(2, testHeap.getSize());
        assertEquals(13, testHeap.getData()[0]);
        assertEquals(12, testHeap.getData()[1]);
    }

    @Test
    public void testParentStealingThirdInsertion(){
        testHeap.insert(13);
        testHeap.insert(14);
        testHeap.insert(15);

        assertEquals(3, testHeap.getSize());
        assertEquals(15, testHeap.getData()[0]);
        assertEquals(13, testHeap.getData()[1]);
        assertEquals(14, testHeap.getData()[2]);
    }

    @Test
    public void testThirdInPlaceInsertion(){
        testHeap.insert(13);
        testHeap.insert(14);
        testHeap.insert(12);

        assertEquals(3, testHeap.getSize());
        assertEquals(14, testHeap.getData()[0]);
        assertEquals(13, testHeap.getData()[1]);
        assertEquals(12, testHeap.getData()[2]);
    }

    @Test
    public void getIndexLocationOfParent(){
        testHeap.insert(10);
        testHeap.insert(9);
        testHeap.insert(8);
        testHeap.insert(7);
        testHeap.insert(6);
        testHeap.insert(5);
        testHeap.insert(4);
        testHeap.insert(3);
        testHeap.insert(2);
        testHeap.insert(1);

        assertEquals(0, Heap.getIndexLocationOfParent(0));
        assertEquals(0, Heap.getIndexLocationOfParent(1));
        assertEquals(0, Heap.getIndexLocationOfParent(2));
        assertEquals(1, Heap.getIndexLocationOfParent(3));
        assertEquals(1, Heap.getIndexLocationOfParent(4));
        assertEquals(2, Heap.getIndexLocationOfParent(5));
        assertEquals(2, Heap.getIndexLocationOfParent(6));
        assertEquals(3, Heap.getIndexLocationOfParent(7));
        assertEquals(3, Heap.getIndexLocationOfParent(8));
        assertEquals(4, Heap.getIndexLocationOfParent(9));
        assertEquals(4, Heap.getIndexLocationOfParent(10));
    }

    @Test
    public void testGrandParentStealingFourthInsertion(){
        testHeap.insert(13);
        testHeap.insert(14);
        testHeap.insert(15);
        testHeap.insert(18);

        assertEquals(4, testHeap.getSize());
        assertEquals(18, testHeap.getData()[0]);
        assertEquals(15, testHeap.getData()[1]);
        assertEquals(14, testHeap.getData()[2]);
        assertEquals(13, testHeap.getData()[3]);
    }

    @Test
    public void testParentStealingFourthInsertion(){
        testHeap.insert(13);
        testHeap.insert(14);
        testHeap.insert(16);
        testHeap.insert(15);

        assertEquals(4, testHeap.getSize());
        assertEquals(16, testHeap.getData()[0]);
        assertEquals(15, testHeap.getData()[1]);
        assertEquals(14, testHeap.getData()[2]);
        assertEquals(13, testHeap.getData()[3]);
    }

    @Test
    public void testInPlaceFourthInsertion(){
        testHeap.insert(13);
        testHeap.insert(14);
        testHeap.insert(15);
        testHeap.insert(1);

        assertEquals(4, testHeap.getSize());
        assertEquals(15, testHeap.getData()[0]);
        assertEquals(13, testHeap.getData()[1]);
        assertEquals(14, testHeap.getData()[2]);
        assertEquals(1, testHeap.getData()[3]);
    }

    @Test
    public void testBlock(){
        testHeap.insert(13);
        testHeap.insert(14);
        testHeap.insert(15);
        testHeap.insert(18);
        testHeap.insert(11);
        testHeap.insert(12);
        testHeap.insert(17);
        testHeap.insert(16);

        assertEquals(8, testHeap.getSize());
        assertEquals(18, testHeap.getData()[0]);
        assertEquals(16, testHeap.getData()[1]);
        assertEquals(17, testHeap.getData()[2]);
        assertEquals(15, testHeap.getData()[3]);
        assertEquals(11, testHeap.getData()[4]);
        assertEquals(12, testHeap.getData()[5]);
        assertEquals(14, testHeap.getData()[6]);
        assertEquals(13, testHeap.getData()[7]);
    }
}
