import static org.junit.Assert.*;

public class BinarySearchTest {

    @org.junit.Test
    public void step() {
        int[] a = new int[] {0,1,3,4};
        BinarySearch search = new BinarySearch(a);
        assertEquals(0,search.Left);
        assertEquals(3,search.Right);
        search.Step(2);
        assertEquals(2,search.Left);
        assertEquals(3,search.Right);
        assertEquals(0,search.GetResult());
        search.Step(2);
        assertEquals(2,search.Left);
        assertEquals(1,search.Right);
        assertEquals(-1,search.GetResult());


        int[] a1 = new int[] {0,1,2,3,4,5,6,7,8};
        BinarySearch search1 = new BinarySearch(a1);
        assertEquals(0,search1.Left);
        assertEquals(8,search1.Right);
        search1.Step(4);
        assertEquals(0,search1.Left);
        assertEquals(8,search1.Right);
        assertTrue(search1.Find);
        assertEquals(1,search1.GetResult());

        int[] a2 = new int[] {0,1,2,3,4,5,6,7,8};
        BinarySearch search2 = new BinarySearch(a2);
        assertEquals(0,search2.Left);
        assertEquals(8,search2.Right);
        search2.Step(0);
        assertEquals(0,search2.Left);
        assertEquals(3,search2.Right);
        assertEquals(0,search2.GetResult());
        search2.Step(0);
        assertEquals(0,search2.Left);
        assertEquals(0,search2.Right);
        assertEquals(0,search2.GetResult());
        search2.Step(0);
        assertEquals(0,search2.Left);
        assertEquals(0,search2.Right);
        assertEquals(1,search2.GetResult());
    }
}