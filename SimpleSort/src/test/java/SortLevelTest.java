import static org.junit.Assert.*;

public class SortLevelTest {

    @org.junit.Test
    public void selectionSortStep() {
        int[] arr = new int[]{4,6,7,2,5,11};
        SortLevel.SelectionSortStep(arr, 0);
        assertEquals(2, arr[0]);
        assertEquals(4, arr[3]);
    }

    @org.junit.Test
    public void bubbleSortStep() {
        int[] arr = new int[]{4,9,6,7,2,5};
        assertFalse(SortLevel.BubbleSortStep(arr));
        assertEquals(6, arr[1]);
        assertEquals(9, arr[5]);
    }
}