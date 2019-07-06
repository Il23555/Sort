import static org.junit.Assert.*;

public class MergeSortTest {

    @org.junit.Test
    public void mergeSortStep() {
        int[] array = new int[] {9,14,12,5,4,10,20,18,25,13};
        MergeSort sort = new MergeSort(array);
        sort.MergeSortStep();
        assertEquals(25,sort.CurrentItem.value);
        sort.MergeSortStep();
        assertEquals(20,sort.CurrentItem.value);
        sort.MergeSortStep();
        assertEquals(18,sort.CurrentItem.value);

        int[] arr = new int[] {9,4,5};
        MergeSort sort1 = new MergeSort(arr);
        sort1.MergeSortStep();
        assertEquals(9,sort1.CurrentItem.value);
    }
}