import static org.junit.Assert.*;

public class MergeSortTest {

    @org.junit.Test
    public void mergeSortStep() {
        int[] arr = new int[] {9,4,5};
        MergeSort sort1 = new MergeSort(arr);
        sort1.MergeSortStep();
        assertEquals(1,sort1.MergeHeap.Len());
        assertEquals(9,sort1.CurrentItem.value);
        sort1.MergeSortStep();
        assertEquals(5,sort1.CurrentItem.value);
        sort1.MergeSortStep();
        assertEquals(4,sort1.CurrentItem.value);
        sort1.MergeSortStep();
        assertEquals(null,sort1.CurrentItem);

        int[] arr2 = new int[] {8,7,6,10,9,5,4};
        MergeSort sort2 = new MergeSort(arr2);
        sort2.MergeSortStep();
        assertEquals(2,sort2.MergeHeap.Len());
        assertEquals(10,sort2.CurrentItem.value);
        sort2.MergeSortStep();
        assertEquals(4,sort2.MergeHeap.Len());
        assertEquals(9,sort2.CurrentItem.value);
        sort2.MergeSortStep();
        assertEquals(8,sort2.CurrentItem.value);
        sort2.MergeSortStep();
        assertEquals(7,sort2.CurrentItem.value);
        sort2.MergeSortStep();
        assertEquals(6,sort2.CurrentItem.value);
        sort2.MergeSortStep();
        assertEquals(5,sort2.CurrentItem.value);
        sort2.MergeSortStep();
        assertEquals(4,sort2.CurrentItem.value);
        sort2.MergeSortStep();
        assertEquals(null,sort2.CurrentItem);

        int[] arr3 = new int[]{2,3,6,5,9,10};
        MergeSort sort4 = new MergeSort(arr3);
        sort4.MergeSortStep();
        assertEquals(10,sort4.CurrentItem.value);
        sort4.MergeSortStep();
        assertEquals(9,sort4.CurrentItem.value);
        sort4.MergeSortStep();
        assertEquals(6,sort4.CurrentItem.value);
        sort4.MergeSortStep();
        assertEquals(5,sort4.CurrentItem.value);
        sort4.MergeSortStep();
        assertEquals(3,sort4.CurrentItem.value);
        sort4.MergeSortStep();
        assertEquals(2,sort4.CurrentItem.value);
        sort4.MergeSortStep();
        assertEquals(null,sort4.CurrentItem);
    }
}
