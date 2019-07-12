import static org.junit.Assert.*;

public class HeapSortTest {

    @org.junit.Test
    public void getNextMax() {
        int[] arr = new int[]{1,1,3,4,7,12,6,20};
        HeapSort sort = new HeapSort(arr);

        assertEquals(20,sort.GetNextMax());
        assertEquals(12,sort.GetNextMax());
        assertEquals(7,sort.GetNextMax());
        assertEquals(6,sort.GetNextMax());
        assertEquals(4,sort.GetNextMax());
        assertEquals(3,sort.GetNextMax());
        assertEquals(1,sort.GetNextMax());
        assertEquals(1,sort.GetNextMax());
        assertEquals(-1,sort.GetNextMax());
    }
}