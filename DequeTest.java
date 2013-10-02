import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class DequeTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateSize() {
        Deque<String> dQ = new Deque<String>();
        assertEquals(0,dQ.size());
    }

    @Test
    public void testInsertSize() {
        Deque<String> dQ = new Deque<String>();
        dQ.addFirst("Hello");
        dQ.addLast("Hello");
        assertEquals(2,dQ.size());
        dQ.removeFirst();
        dQ.removeLast();
        assertEquals(0,dQ.size());
    } 

    @Test
    public void testAddFirstRemoveLast() {
        Deque<String> dQ = new Deque<String>();
        String str = "Hello";
        dQ.addFirst(str);
        assertEquals("Hello",dQ.removeLast());
    }

    @Test
    public void testAddLastRemoveFirst() {
        Deque<String> dQ = new Deque<String>();
        String str = "Hello";
        dQ.addLast(str);
        assertEquals("Hello",dQ.removeFirst());
    }

    @Test
    public void testAddFirstRemoveFirst() {
        Deque<String> dQ = new Deque<String>();
        String str = "Hello";
        dQ.addFirst(str);
        assertEquals("Hello",dQ.removeFirst());
    }

    @Test
    public void testAddLasttRemoveLast() {
        Deque<String> dQ = new Deque<String>();
        String str = "Hello";
        dQ.addLast(str);
        assertEquals("Hello",dQ.removeLast());
    }

    @Test
    public void testIterator() {
        int[] arr = {1,2,3,4,5,6};
        int[] brr = new int[6];
        Deque<Integer> dQ = new Deque<Integer>();
        for (int i:arr)
            dQ.addLast(i);
        int idx = 0;
        for (int i:dQ)
            brr[idx++] = i;
        assertArrayEquals(brr, arr);
    }
}
