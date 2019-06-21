import static org.junit.Assert.*;

public class SimpleSortTest {

    @org.junit.Test
    public void selectionSort() {
        int[] arr = new int[]{4,6,7,2,5,1,3,8};
        SimpleSort.SelectionSort(arr);
        for (int i = 0; i < arr.length ; i++) {
            assertEquals(i+1,arr[i]);
        }
    }

    @org.junit.Test
    public void bubbleSort() {
        int[] arr = new int[]{6,7,10,9,8,5};
        SimpleSort.BubbleSort(arr);
        for (int i = 0; i < arr.length ; i++) {
            assertEquals(i+5,arr[i]);
        }
    }
}