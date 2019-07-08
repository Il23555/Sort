import static org.junit.Assert.*;

public class MergeSortTest {

    @org.junit.Test
    public void mergeSortStep() {

        int[] arr1 = new int[] {4,5,9,12,14,10,13,18,25,20};
        MergeSort sort = new MergeSort(arr1);
        assertEquals(0,sort.MergeHeap.Len());
        sort.MergeSortStep();
        assertEquals(2,sort.MergeHeap.Len());
        assertEquals(25,sort.CurrentItem.value);
        sort.MergeSortStep();
        assertEquals(20,sort.CurrentItem.value);
        sort.MergeSortStep();
        assertEquals(18,sort.CurrentItem.value);
        sort.MergeSortStep();
        assertEquals(14,sort.CurrentItem.value);
        sort.MergeSortStep();
        assertEquals(13,sort.CurrentItem.value);
        sort.MergeSortStep();
        assertEquals(12,sort.CurrentItem.value);
        sort.MergeSortStep();
        assertEquals(10,sort.CurrentItem.value);

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
        sort4.MergeHeap.Add(1,2);
        sort4.MergeHeap.Add(2,5);
        assertEquals(2,sort4.MergeHeap.Len());
        sort4.MergeHeap.Add(1,3);
        sort4.MergeHeap.Add(1,6);
        sort4.MergeHeap.Add(1,9);
        assertEquals(5,sort4.MergeHeap.Len());
        sort4.MergeHeap.GetMax();
        assertEquals(4,sort4.MergeHeap.Len());
        sort4.MergeHeap.GetMax();
        assertEquals(3,sort4.MergeHeap.Len());
    }
}
