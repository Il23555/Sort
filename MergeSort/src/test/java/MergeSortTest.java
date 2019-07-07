import static org.junit.Assert.*;

public class MergeSortTest {

    @org.junit.Test
    public void mergeSortStep() {

        int[] arr1 = new int[] {9,14,12,5,4,10,20,18,25,13};
        MergeSort sort = new MergeSort(arr1);
        assertEquals(0,sort.MergeHeap.Len());
        sort.MergeSortStep();
        assertEquals(2,sort.MergeHeap.Len());
        assertEquals(25,sort.CurrentItem.value);
        sort.MergeSortStep();
        assertEquals(20,sort.CurrentItem.value);

        int[] arr = new int[] {9,4,5};
        MergeSort sort1 = new MergeSort(arr);
        sort1.MergeSortStep();
        assertEquals(1,sort1.MergeHeap.Len());
        assertEquals(9,sort1.CurrentItem.value);

        int[] arr2 = new int[] {7,6,8,5,9,4,10};
        MergeSort sort2 = new MergeSort(arr2);
        sort2.MergeSortStep();
        assertEquals(2,sort2.MergeHeap.Len());
        assertEquals(10,sort2.CurrentItem.value);
        sort2.MergeSortStep();
        assertEquals(2,sort2.MergeHeap.Len());
        assertEquals(9,sort2.CurrentItem.value);

    }
}