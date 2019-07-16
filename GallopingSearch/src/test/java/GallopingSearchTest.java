import static org.junit.Assert.*;

public class GallopingSearchTest {

    @org.junit.Test
    public void step() {
        int[] a  = new int[]{1};
        GallopingSearch search = new GallopingSearch(a);
        search.Step(2);
        assertEquals(1,search.Left);
        assertEquals(0,search.Right);
        assertEquals(0,search.GetResult());
        search.Step(2);
        assertEquals(-1,search.GetResult());

        int[] a1  = new int[]{1,2};
        GallopingSearch search1 = new GallopingSearch(a1);
        search1.Step(2);
        assertEquals(1,search1.Left);
        assertEquals(1,search1.Right);
        assertEquals(0,search1.GetResult());
        search1.Step(2);
        assertEquals(1,search1.GetResult());

        int[] a2  = new int[]{0,1,2,3,4,5};
        GallopingSearch search2 = new GallopingSearch(a2);
        search2.Step(3);
        assertEquals(1,search2.Left);
        assertEquals(5,search2.Right);
        assertEquals(0,search2.GetResult());
        search2.Step(3);
        assertEquals(2,search2.Left);
        assertEquals(5,search2.Right);
        assertEquals(0,search2.GetResult());
        search2.Step(3);
        assertEquals(4,search2.Left);
        assertEquals(5,search2.Right);
        assertEquals(0,search2.GetResult());
        search2.Step(3);
        assertEquals(1,search2.Left);
        assertEquals(2,search2.Right);
        assertEquals(0,search2.GetResult());
        search2.Step(3);
        assertEquals(1,search2.Left);
        assertEquals(1,search2.Right);
        assertEquals(1,search2.GetResult());

        int[] a3  = new int[]{0,1,2,3,4,5};
        GallopingSearch search3 = new GallopingSearch(a3);
        search3.Step(5);
        assertEquals(1,search3.Left);
        assertEquals(5,search3.Right);
        assertEquals(0,search3.GetResult());
        search3.Step(5);
        assertEquals(2,search3.Left);
        assertEquals(5,search3.Right);
        assertEquals(0,search3.GetResult());
        search3.Step(5);
        assertEquals(4,search3.Left);
        assertEquals(5,search3.Right);
        assertEquals(0,search3.GetResult());
        search3.Step(5);
        assertEquals(8,search3.Left);
        assertEquals(5,search3.Right);
        assertEquals(0,search3.GetResult());
        search3.Step(5);
        assertEquals(5,search3.Left);
        assertEquals(5,search3.Right);
        assertEquals(1,search3.GetResult());



    }


}