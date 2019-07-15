import static org.junit.Assert.*;

public class BinarySearchTest {

    @org.junit.Test
    public void step() {
        int[] a = new int[] {0,1,3,4};
        BinarySearch search = new BinarySearch(a);
        assertEquals(0,search.Left);
        assertEquals(3,search.Right);
        search.Step(2);
        assertEquals(0,search.Left);
        assertEquals(1,search.Right);
        assertEquals(0,search.GetResult());
        search.Step(2);
        assertEquals(2,search.Left);
        assertEquals(1,search.Right);
        assertEquals(-1,search.GetResult());

        int[] a1 = new int[] {1,2,3,4,5,6};
        BinarySearch search1 = new BinarySearch(a1);
        assertEquals(0,search1.Left);
        assertEquals(5,search1.Right);
        search1.Step(4);
        assertEquals(0,search1.Left);
        assertEquals(5,search1.Right);
        assertEquals(1,search1.GetResult());

        int[] a2 = new int[] {1,2,3,4,5,6};
        BinarySearch search2 = new BinarySearch(a2);
        assertEquals(0,search2.Left);
        assertEquals(5,search2.Right);
        search2.Step(5);
        assertEquals(4,search2.Left);
        assertEquals(5,search2.Right);
        assertEquals(0,search2.GetResult());
        search2.Step(5);
        assertEquals(4,search2.Left);
        assertEquals(4,search2.Right);
        assertEquals(0,search2.GetResult());
        search2.Step(5);
        assertEquals(1,search2.GetResult());

        int[] a3 = new int[] {1,2,3,4,5,6};
        BinarySearch search3 = new BinarySearch(a3);
        assertEquals(0,search3.Left);
        assertEquals(5,search3.Right);
        search3.Step(6);
        assertEquals(4,search3.Left);
        assertEquals(5,search3.Right);
        assertEquals(0,search3.GetResult());
        search3.Step(6);
        assertEquals(1,search3.GetResult());

        int[] a4 = new int[] {1,2,3,4,5,6};
        BinarySearch search4 = new BinarySearch(a3);
        assertEquals(0,search4.Left);
        assertEquals(5,search4.Right);
        search4.Step(3);
        assertEquals(0,search4.Left);
        assertEquals(2,search4.Right);
        assertEquals(0,search4.GetResult());
        search4.Step(3);
        assertEquals(2,search4.Left);
        assertEquals(2,search4.Right);
        assertEquals(0,search4.GetResult());
        search4.Step(3);
        assertEquals(1,search4.GetResult());

        int[] a5 = new int[]{1,1,1,2,5,7,8,12,15,18,25};
        BinarySearch search5 = new BinarySearch(a5);
        while (search5.GetResult() == 0) {
            search5.Step(25);
        }
        assertEquals(1,search5.GetResult());
    }
}