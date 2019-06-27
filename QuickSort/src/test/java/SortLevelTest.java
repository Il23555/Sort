import org.junit.Test;

public class SortLevelTest {

    @Test
    public void quickSort() {
        int[] arr = new int[]{2,1,3,0,4,9,6,5};
        SortLevel.QuickSort(arr,0, arr.length-1);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]);
        }
    }
}